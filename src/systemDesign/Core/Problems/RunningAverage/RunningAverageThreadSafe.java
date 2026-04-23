package systemDesign.Core.Problems.RunningAverage;

import java.util.LinkedList;
import java.util.Queue;

public class RunningAverageThreadSafe {
    private final Queue<Integer> lastNElements;
    private final int n;
    private double average;
    private long sum;

    public RunningAverageThreadSafe(int n)
    {
        this.n = n;
        lastNElements = new LinkedList<>();
        average = 0.0;
        sum = 0;
    }

    public synchronized double next(int num)
    {
        lastNElements.add(num);
        sum += num;

        if(!lastNElements.isEmpty() && lastNElements.size() > n)
        {
            int top = lastNElements.poll();
            sum -= top;
        }
        average = ((double) sum/ (double) lastNElements.size());
        return average;
    }


    public static void main(String[] args) throws InterruptedException
    {
        int n = 7;
        RunningAverageThreadSafe runningAverage = new RunningAverageThreadSafe(n);
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i<100; i+=2)
            {
                double average = runningAverage.next(i);
                System.out.println("Added - " + i);
                if(i % 3 == 0)
                {
                    System.out.println("Last " + n + " elements average = "
                            + average);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 2; i<100; i+=2)
            {
                double average = runningAverage.next(i);
                System.out.println("Added - " + i);
                if(i % 3 == 0)
                {
                    System.out.println("Last " + n + " elements average = "
                            + average);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
