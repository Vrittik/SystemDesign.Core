package systemDesign.Core.Problems.TopKHeavyHittersStream;

import java.util.*;

public class HeavyHittersCandidates {
    private final int k;
    private final Map<Integer, Integer> topKCandidates;

    public HeavyHittersCandidates(int k)
    {
        this.k = k;
        topKCandidates = new HashMap<>();
    }

    public void hit(int key)
    {
        if(topKCandidates.containsKey(key))
        {
            topKCandidates.put(key, topKCandidates.get(key) + 1);
        }
        else
        {
            if(topKCandidates.size() == k) {
                Iterator<Map.Entry<Integer, Integer>> it = topKCandidates.entrySet().iterator();
                while (it.hasNext())
                {
                    Map.Entry<Integer, Integer> temp = it.next();
                    if (temp.getValue() == 1) {
                        it.remove();
                    } else {
                        temp.setValue(temp.getValue() -1);
                    }
                }
            }
            if(topKCandidates.size() < k)
            {
                topKCandidates.put(key, 1);
            }
        }
        System.out.println("Hit - " + key);
    }

    public List<Integer> getTopK()
    {
        return new ArrayList<>(topKCandidates.keySet());
    }

    public static void main(String[] args)
    {
        HeavyHittersCandidates topkHeavyHitters = new HeavyHittersCandidates(2);
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
        topkHeavyHitters.hit(4);
        topkHeavyHitters.hit(4);
        printTopK(topkHeavyHitters);
        topkHeavyHitters.hit(4);
        printTopK(topkHeavyHitters);

        // Complexity = O(K) for remove
    }

    public static void printTopK(HeavyHittersCandidates heavyHitters)
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
