package systemDesign.Core.Problems.ThreadSafeQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ObserverQueuePattern<T> {

    private final Queue<T> syncQueue;
    private final int capacity;

    public ObserverQueuePattern(int capacity)
    {
        syncQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void offer(T element) throws InterruptedException
    {
        while(syncQueue.size() == capacity)
        {
            wait();
        }
        syncQueue.add(element);
        notifyAll();
    }

    public synchronized T poll() throws InterruptedException
    {
        while(syncQueue.isEmpty())
        {
            wait();
        }
        T top = syncQueue.poll();
        notifyAll();
        return top;
    }

    public int size()
    {
        return syncQueue.size();
    }

    public static void main(String[] args) throws InterruptedException
    {
        ObserverQueuePattern<Integer> observerQueue = new ObserverQueuePattern<>(10000);

        // Producer threads
        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    observerQueue.offer(i);
                }
                catch(Exception ex)
                {

                }
            }
        });

        Thread producer2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try{
                observerQueue.offer(i);
                } catch (Exception ex)
                {

                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            int removed = 0;

            while (removed < 15000) {
                try {
                    Integer val = observerQueue.poll();
                    if (val != null) {
                        removed++;
                    }
                }
                catch (Exception ex)
                {

                }
            }
        });

        producer1.start();
        producer2.start();
        consumer.start();

        producer1.join();
        producer2.join();
        consumer.join();

        System.out.println("Final size: " + observerQueue.size());
    }
}