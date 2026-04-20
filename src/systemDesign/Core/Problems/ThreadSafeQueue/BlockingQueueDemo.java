package systemDesign.Core.Problems.ThreadSafeQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        // Producer threads
        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                blockingQueue.offer(i);
            }
        });

        Thread producer2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                blockingQueue.offer(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            int removed = 0;

            while (removed < 15000) {
                Integer val = blockingQueue.poll();
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

        System.out.println("Final size: " + blockingQueue.size());
    }
}
