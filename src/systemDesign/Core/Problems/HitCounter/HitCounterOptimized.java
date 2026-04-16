package systemDesign.Core.Problems.HitCounter;

public class HitCounterOptimized {
    private final int[] hitTimeStamps;
    private final int[] hitCounts;
    private final int lastNSeconds = 10;

    public HitCounterOptimized()
    {
        hitTimeStamps = new int[lastNSeconds];
        hitCounts = new int[lastNSeconds];
    }

    public void hit()
    {
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        System.out.println("Hit at - " + now);
        int circularCurrentTime = now % lastNSeconds;

        if(hitTimeStamps[circularCurrentTime] != now)
        {
            hitTimeStamps[circularCurrentTime] = now;
            hitCounts[circularCurrentTime] = 1;
        }
        else{
            hitCounts[circularCurrentTime]++;
        }
    }

    public int getHits()
    {
        int count = 0;
        int now = getCurrentTimeSeconds(System.currentTimeMillis());
        for(int i = 0; i<lastNSeconds; i++)
        {
            if(now - hitTimeStamps[i] <= lastNSeconds)
            {
                count += hitCounts[i];
            }
        }
        return count;
    }

    public int getCurrentTimeSeconds(long now)
    {
        return (int) (now/1000);
    }

    public static void main(String[] args)
    {
        HitCounterOptimized hitCounterOptimized = new HitCounterOptimized();

        for(int i = 0; i<10; i++)
        {
            hitCounterOptimized.hit();
            try
            {
                System.out.println("waiting for 1 second.....- ");
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {

            }
        }
        // 10 hits will come in the last 10 seconds
        System.out.println("Hits in the last 10 seconds = " + hitCounterOptimized.getHits());

        // Waiting for 1 more second and then calculating the hits
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {

        }
        // 8 or 9 hits will come in the last 10 seconds, 1 or 2 hits discarded
        System.out.println("Hits in the last 10 seconds = " + hitCounterOptimized.getHits());
    }
}
