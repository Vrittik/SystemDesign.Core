package systemDesign.Core.Problems.RunningAverage;

import java.util.LinkedList;
import java.util.Queue;

public class RunningAverage {
    private final Queue<Integer> lastNElements;
    private final int n;
    private double average;
    private long sum;

    public RunningAverage(int n)
    {
        this.n = n;
        lastNElements = new LinkedList<>();
        average = 0.0;
        sum = 0;
    }

    public double next(int num)
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


    public static void main(String[] args)
    {
        int n = 7;
        RunningAverage runningAverage = new RunningAverage(n);

        for(int i = 1; i<100; i++)
        {
            double average = runningAverage.next(i);
            System.out.println("Added - " + i);
            if(i % 3 == 0)
            {
                System.out.println("Last " + n + " elements average = "
                        + average);
            }
        }
    }
}
