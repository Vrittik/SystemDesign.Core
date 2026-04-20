package systemDesign.Core.Problems.StreamMedian;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> leftHalf;
    private final PriorityQueue<Integer> rightHalf;

    public MedianFinder() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
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

    public double findMedian() {
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
        MedianFinder medianFinder = new MedianFinder();
        for(int i = 1; i<10; i++)
        {
            medianFinder.addNum(i);
            System.out.println("Added - " + i);
            System.out.println("New Median = " + medianFinder.findMedian());
        }
    }
}
