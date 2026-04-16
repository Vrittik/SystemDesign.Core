package systemDesign.Core.Problems.HitCounter;

public class HitCounterOptimizedThreadSafe {
    private final int[] hitTimeStamps;
    private final int[] hitCounts;
    private final int lastNSeconds = 10;

    public HitCounterOptimizedThreadSafe()
    {
        hitTimeStamps = new int[lastNSeconds];
        hitCounts = new int[lastNSeconds];
    }

    public synchronized void hit()
    {
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        System.out.println("Hit at - " + now + " By Thread - " + Thread.currentThread().getName());
        int circularCurrentTime = now % lastNSeconds;

        if(hitTimeStamps[circularCurrentTime] != now)
        {
            hitTimeStamps[circularCurrentTime] = now;
            hitCounts[circularCurrentTime] = 1;
        }
        else{
            hitCounts[circularCurrentTime]++;
        }
    }

    public synchronized int getHits()
    {
        int count = 0;
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        for(int i = 0; i<lastNSeconds; i++)
        {
            if(now - hitTimeStamps[i] <= lastNSeconds)
            {
                count += hitCounts[i];
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
        HitCounterOptimizedThreadSafe hitCounterOptimizedThreadSafe = new HitCounterOptimizedThreadSafe();

        Thread thread1 = new Thread(() -> {
            hitCounterOptimizedThreadSafe.doTask();
        });

        Thread thread2 = new Thread(() -> {
            hitCounterOptimizedThreadSafe.doTask();
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
        System.out.println("Hits in the last 10 seconds = " + hitCounterOptimizedThreadSafe.getHits());

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
        System.out.println("Hits in the last 10 seconds = " + hitCounterOptimizedThreadSafe.getHits());
    }

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
