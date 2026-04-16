package systemDesign.Core.Problems.HitCounter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class HitCounterOptimizedThreadSafeGranular {
    private final AtomicInteger[] hitTimeStamps;
    private final AtomicInteger[] hitCounts;
    private final int lastNSeconds = 10;
    private final ReentrantLock[] locks = new ReentrantLock[lastNSeconds];

    public HitCounterOptimizedThreadSafeGranular()
    {
        hitTimeStamps = new AtomicInteger[lastNSeconds];
        hitCounts = new AtomicInteger[lastNSeconds];
        for(int i = 0; i<lastNSeconds; i++)
        {
            hitCounts[i] = new AtomicInteger(0);
            locks[i] = new ReentrantLock();
            hitTimeStamps[i] = new AtomicInteger(0);
        }
    }

    public void hit()
    {
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        System.out.println("Hit at - " + now + " By Thread - " + Thread.currentThread().getName());
        int circularCurrentTime = now % lastNSeconds;

        try {
            // Acquire index level lock rather than synchronized
            locks[circularCurrentTime].lock();

            // We needed lock because we are updating 2 things together
            // Atomic integer only gives safe writes for one variable not as
            // two different operations. (Update timestamp and hit count)
            if (hitTimeStamps[circularCurrentTime].get() != now) {
                hitTimeStamps[circularCurrentTime].set(now);
                hitCounts[circularCurrentTime].set(1);
            } else {
                hitCounts[circularCurrentTime].incrementAndGet();
            }
        }
        finally {
            // Release index level lock
            locks[circularCurrentTime].unlock();
        }
    }

    // getHits doesn't need to be synchronized, some approximation is ok
    public int getHits()
    {
        int count = 0;
        int now = getCurrentTimeSeconds(System.currentTimeMillis());

        for(int i = 0; i<lastNSeconds; i++)
        {
            int ts = hitTimeStamps[i].get();
            if(now - ts <= lastNSeconds)
            {
                // Atomic integer gives safe reads, so no lock required
                // Here there is only one single read operation for a single
                // variable that's why atomic integer will do the concurrency
                // handling lock free
                count += hitCounts[i].get();
            }
        }
        return count;
    }

    public int getCurrentTimeSeconds(long now)
    {
        return (int) (now/1000);
    }

    public static void main(String[] args)
    {
        HitCounterOptimizedThreadSafeGranular HitCounterOptimizedThreadSafeGranular = new HitCounterOptimizedThreadSafeGranular();

        Thread thread1 = new Thread(() -> {
            HitCounterOptimizedThreadSafeGranular.doTask();
        });

        Thread thread2 = new Thread(() -> {
            HitCounterOptimizedThreadSafeGranular.doTask();
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }
        catch(InterruptedException ex)
        {

        }

        // 20 hits will come in the last 10 seconds
        System.out.println("Hits in the last 10 seconds = " + HitCounterOptimizedThreadSafeGranular.getHits());

        // Waiting for 1 more second and then calculating the hits
        try
        {
            System.out.println("waiting for 1 second.....");
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {

        }
        // 18 or 19 hits will come in the last 10 seconds, 1 or 2 hits discarded
        System.out.println("Hits in the last 10 seconds = " + HitCounterOptimizedThreadSafeGranular.getHits());
    }

    // Hit 10 times with 1 second delay in each hit
    public void doTask()
    {
        for(int i = 0; i<10; i++)
        {
            hit();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {

            }
        }
    }
}
