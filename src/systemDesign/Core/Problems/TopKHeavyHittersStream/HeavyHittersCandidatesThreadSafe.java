package systemDesign.Core.Problems.TopKHeavyHittersStream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class HeavyHittersCandidatesThreadSafe {
    private final int k;
    private final Map<Integer, Integer> topKCandidates;
    private ReentrantLock reentrantLock;

    public HeavyHittersCandidatesThreadSafe(int k)
    {
        this.k = k;
        topKCandidates = new ConcurrentHashMap<>();
        reentrantLock = new ReentrantLock();
    }

    public void hit(int key)
    {
        try {
            reentrantLock.lock();
            if (topKCandidates.containsKey(key)) {
                topKCandidates.put(key, topKCandidates.get(key) + 1);
            } else {
                if (topKCandidates.size() == k) {
                    Iterator<Map.Entry<Integer, Integer>> it = topKCandidates.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Integer> temp = it.next();
                        if (temp.getValue() == 1) {
                            it.remove();
                        } else {
                            temp.setValue(temp.getValue() - 1);
                        }
                    }
                }
                if (topKCandidates.size() < k) {
                    topKCandidates.put(key, 1);
                }
            }
        }
        catch (Exception ex)
        {

        }
        finally {
            reentrantLock.unlock();
        }
    }

    public List<Integer> getTopK()
    {
        try {
            reentrantLock.lock();
            return new ArrayList<>(topKCandidates.keySet());
        }
        finally {
            // To maintain sync with put operation
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        HeavyHittersCandidatesThreadSafe topkHeavyHitters = new HeavyHittersCandidatesThreadSafe(2);

        Thread thread1 = new Thread(()->{
            topkHeavyHitters.hit(1);
            topkHeavyHitters.hit(1);
            topkHeavyHitters.hit(1);
            topkHeavyHitters.hit(2);
            printTopK(topkHeavyHitters);
        });

        Thread thread2 = new Thread(()->{
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
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        // Complexity = O(K) for remove
    }

    // Just for print purpose
    public static synchronized void printTopK(HeavyHittersCandidatesThreadSafe heavyHitters)
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
