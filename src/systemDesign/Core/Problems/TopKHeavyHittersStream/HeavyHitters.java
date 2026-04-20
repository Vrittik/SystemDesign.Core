package systemDesign.Core.Problems.TopKHeavyHittersStream;

import java.util.*;

public class HeavyHitters {
    private final int k;
    private final Map<Integer, Integer> freq;
    private final PriorityQueue<Integer> topKHitters;

    public HeavyHitters(int k)
    {
        this.k = k;
        freq = new HashMap<>();
        topKHitters = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(a), freq.get(b)));
    }

    public void hit(int key)
    {
        freq.put(key, freq.getOrDefault(key, 0) + 1);

        // O(K)
        topKHitters.remove(key);
        topKHitters.add(key);

        if(topKHitters.size() > k) topKHitters.poll();

        System.out.println("Hit - " + key);
    }

    public List<Integer> getTopK()
    {
        return new ArrayList<>(topKHitters);
    }

    public static void main(String[] args)
    {
        HeavyHitters topkHeavyHitters = new HeavyHitters(2);
        topkHeavyHitters.hit(1);
        topkHeavyHitters.hit(1);
        topkHeavyHitters.hit(1);
        topkHeavyHitters.hit(2);
        printTopK(topkHeavyHitters);
        topkHeavyHitters.hit(2);
        printTopK(topkHeavyHitters);
        topkHeavyHitters.hit(3);
        topkHeavyHitters.hit(3);
        topkHeavyHitters.hit(3);
        printTopK(topkHeavyHitters);

        // Complexity = O(K) for remove
    }

    public static void printTopK(HeavyHitters heavyHitters)
    {
        System.out.print("Heavy hitters - ");
        List<Integer> topK = heavyHitters.getTopK();
        for(var x : topK)
        {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
