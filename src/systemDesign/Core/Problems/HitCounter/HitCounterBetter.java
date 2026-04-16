package systemDesign.Core.Problems.HitCounter;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounterBetter {
    private final Queue<Integer> hitTimeStamps;

    public HitCounterBetter()
    {
        hitTimeStamps = new LinkedList<>();
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
        System.out.println("Current time while calculating last 10 hits = " + now);
        while(!hitTimeStamps.isEmpty() && now - hitTimeStamps.peek() > 10)
        {
            // if (now - hitTimeStamps.get(i) <= 300)
            // For understanding purpose, marking it 10 seconds instead of 300
           hitTimeStamps.poll();
        }
        return hitTimeStamps.size();
    }

    public int getCurrentTimeSeconds(long now)
    {
        return (int) (now/1000);
    }

    public static void main(String[] args)
    {
        HitCounterBetter hitCounterBetter = new HitCounterBetter();

        for(int i = 0; i<10; i++)
        {
            hitCounterBetter.hit();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {

            }
        }
        // 10 hits will come in the last 10 seconds
        System.out.println("Hits in the last 10 seconds = " + hitCounterBetter.getHits());

        // Waiting for 1 more second and then calculating the hits
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {

        }
        // 8 or 9 hits will come in the last 10 seconds, 1 or 2 hits discarded
        System.out.println("Hits in the last 10 seconds = " + hitCounterBetter.getHits());
    }
}
