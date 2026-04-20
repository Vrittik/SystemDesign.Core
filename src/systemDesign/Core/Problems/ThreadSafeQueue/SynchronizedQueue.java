package systemDesign.Core.Problems.ThreadSafeQueue;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedQueue<T> {

    private final Queue<T> syncQueue;
    public SynchronizedQueue()
    {
        syncQueue = new LinkedList<>();
    }

    public synchronized void offer(T element)
    {
        syncQueue.add(element);
    }

    public synchronized T poll()
    {
        if(syncQueue.isEmpty())
        {
            return null;
        }
        return syncQueue.poll();
    }

    public int size()
    {
        return syncQueue.size();
    }

    public static void main(String[] args) throws InterruptedException
    {
        SynchronizedQueue<Integer> syncQueue = new SynchronizedQueue<>();

        // Producer threads
        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                syncQueue.offer(i);
            }
        });

        Thread producer2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                syncQueue.offer(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            int removed = 0;

            while (removed < 15000) {
                Integer val = syncQueue.poll();
                if (val != null) {
                    removed++;
                }
            }
        });

        producer1.start();
        producer2.start();
        consumer.start();

        producer1.join();
        producer2.join();
        consumer.join();

        System.out.println("Final size: " + syncQueue.size());
    }
}
