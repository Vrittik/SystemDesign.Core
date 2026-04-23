package systemDesign.Core.Problems.FirstUniqueInStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueNaive {
    private final List<Integer> numbers;
    private final Map<Integer, Integer> freq;

    public FirstUniqueNaive()
    {
        numbers = new ArrayList<>();
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
        for(int number : numbers)
        {
            if(freq.get(number) == 1)
            {
                return number;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        FirstUniqueNaive firstUniqueNaive = new FirstUniqueNaive();

        firstUniqueNaive.putNumber(1);
        firstUniqueNaive.putNumber(2);
        firstUniqueNaive.putNumber(3);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
        firstUniqueNaive.putNumber(1);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
        firstUniqueNaive.putNumber(2);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
        firstUniqueNaive.putNumber(4);
        firstUniqueNaive.putNumber(5);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
        firstUniqueNaive.putNumber(6);
        firstUniqueNaive.putNumber(7);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
        firstUniqueNaive.putNumber(3);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
        firstUniqueNaive.putNumber(4);
        firstUniqueNaive.putNumber(5);
        System.out.println("First unique = " + firstUniqueNaive.getFirstUnique());
    }
}
