package systemDesign.Core.Problems.HitCounter;

import java.util.ArrayList;
import java.util.List;

public class HitCounterNaive {
    private final List<Integer> hitTimeStamps;

    public HitCounterNaive()
    {
        hitTimeStamps = new ArrayList<>();
    }

    public void hit()
    {
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        System.out.println("Hit at - " + now);
        hitTimeStamps.add(now);
    }

    public int getHits()
    {
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        int count = 0;
        int i = hitTimeStamps.size()-1;
        System.out.println("Current time while calculating last 10 hits = " + now);
        while(i >= 0)
        {
            // if (now - hitTimeStamps.get(i) <= 300)
            // For understanding purpose, marking it 10seconds instead of 300
            if (now - hitTimeStamps.get(i) <= 10)
            {
                count++;
            }
            else {
                break;
            }
            i--;
        }
        return count;
    }

    public int getCurrentTimeSeconds(long now)
    {
        return (int) (now/1000);
    }

    public static void main(String[] args)
    {
        HitCounterNaive hitCounterNaive = new HitCounterNaive();

        for(int i = 0; i<10; i++)
        {
            hitCounterNaive.hit();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {

            }
        }
        // 10 hits will come in the last 10 seconds
        System.out.println("Hits in the last 10 seconds = " + hitCounterNaive.getHits());

        // Waiting for 1 more second and then calculating the hits
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {

        }
        // 8 or 9 hits will come in the last 10 seconds, 1 or 2 hits discarded
        System.out.println("Hits in the last 10 seconds = " + hitCounterNaive.getHits());
    }
}
