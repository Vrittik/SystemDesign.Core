package systemDesign.Core.Problems.FirstUniqueInStream;

import java.util.*;

public class FirstUniqueOptimized {
    private final Queue<Integer> numbers;
    private final Map<Integer, Integer> freq;

    public FirstUniqueOptimized()
    {
        numbers = new LinkedList<>();
        freq = new HashMap<>();
    }

    public void putNumber(int num)
    {
        System.out.println(num + " added to the collection");
        if(!freq.containsKey(num)) {
            numbers.add(num);
        }
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    public int getFirstUnique()
    {
        while(!numbers.isEmpty() && freq.get(numbers.peek()) > 1)
        {
            numbers.poll();
        }
        return numbers.isEmpty() ? -1 : numbers.peek();
    }

    public static void main(String[] args)
    {
        FirstUniqueOptimized firstUniqueOptimized = new FirstUniqueOptimized();

        firstUniqueOptimized.putNumber(1);
        firstUniqueOptimized.putNumber(2);
        firstUniqueOptimized.putNumber(3);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
        firstUniqueOptimized.putNumber(1);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
        firstUniqueOptimized.putNumber(2);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
        firstUniqueOptimized.putNumber(4);
        firstUniqueOptimized.putNumber(5);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
        firstUniqueOptimized.putNumber(6);
        firstUniqueOptimized.putNumber(7);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
        firstUniqueOptimized.putNumber(3);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
        firstUniqueOptimized.putNumber(4);
        firstUniqueOptimized.putNumber(5);
        System.out.println("First unique = " + firstUniqueOptimized.getFirstUnique());
    }
}

