package systemDesign.Core.Problems.StreamMedian;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinderThreadSafe {

    private final PriorityQueue<Integer> leftHalf;
    private final PriorityQueue<Integer> rightHalf;

    public MedianFinderThreadSafe() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }

    public synchronized void addNum(int num) {
        leftHalf.add(num);
        if(leftHalf.size() > rightHalf.size())
        {
            int top = leftHalf.poll();
            rightHalf.add(top);
        }
        if(!leftHalf.isEmpty() && !rightHalf.isEmpty() &&
                leftHalf.peek() > rightHalf.peek())
        {
            int left = leftHalf.poll();
            int right = rightHalf.poll();
            leftHalf.add(right);
            rightHalf.add(left);
        }
    }

    public synchronized double findMedian() {
        if(leftHalf.size() < rightHalf.size())
        {
            return (double) (rightHalf.peek());
        }
        double left = leftHalf.peek();
        double right = rightHalf.peek();
        return (double)(left + right)/2.0;
    }

    public static void main(String[] args)
    {
        MedianFinderThreadSafe medianFinder = new MedianFinderThreadSafe();

        // First thread
        Thread thread1 = new Thread(() -> {
            addNumsFromStream(medianFinder, 1, 10, 2);
        });
        Thread thread2 = new Thread(() -> {
            addNumsFromStream(medianFinder, 2, 10, 2);
        });

        thread1.start();
        thread2.start();

        try
        {
            thread1.join();
            thread2.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Error occurred - " + ex.getMessage());
        }
    }

    public static void addNumsFromStream(MedianFinderThreadSafe medianFinder,
                                         int start, int end, int gap)
    {
        for(int i = start; i<end; i+=gap)
        {
            medianFinder.addNum(i);
            System.out.println("Added - " + i + " By Thread - " + Thread.currentThread().getName());
            System.out.println("New Median = " + medianFinder.findMedian());
        }
    }
}

