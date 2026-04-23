package systemDesign.Core.Problems.FirstUniqueInStream;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class FirstUniqueOptimizedThreadSafe {
    private final Queue<Integer> numbers;
    private final Map<Integer, Integer> freq;
    private final ReentrantLock reentrantLock;

    public FirstUniqueOptimizedThreadSafe()
    {
        numbers = new LinkedList<>();
        freq = new HashMap<>();
        reentrantLock = new ReentrantLock();
    }

    public void putNumber(int num)
    {
        reentrantLock.lock();
        try {
            System.out.println(num + " added to the collection");
            if (!freq.containsKey(num)) {
                numbers.add(num);
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public int getFirstUnique()
    {
        reentrantLock.lock();
        try {
            while (!numbers.isEmpty() && freq.get(numbers.peek()) > 1) {
                numbers.poll();
            }
            return numbers.isEmpty() ? -1 : numbers.peek();
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        FirstUniqueOptimizedThreadSafe obj =
                new FirstUniqueOptimizedThreadSafe();

        Runnable writer1 = () -> {
            obj.putNumber(1);
            sleep(100);
            obj.putNumber(2);
            sleep(100);
            obj.putNumber(3);
        };

        Runnable writer2 = () -> {
            obj.putNumber(2);
            sleep(100);
            obj.putNumber(4);
            sleep(100);
            obj.putNumber(1);
        };

        Runnable reader = () -> {
            for (int i = 0; i < 6; i++) {
                int first = obj.getFirstUnique();
                System.out.println(
                        Thread.currentThread().getName()
                                + " -> First Unique = " + first
                );
                sleep(80);
            }
        };

        Thread t1 = new Thread(writer1, "Writer-1");
        Thread t2 = new Thread(writer2, "Writer-2");
        Thread t3 = new Thread(reader, "Reader");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final First Unique = "
                + obj.getFirstUnique());
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
