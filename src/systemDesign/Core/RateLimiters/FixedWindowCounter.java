package systemDesign.Core.RateLimiters;

public class FixedWindowCounter {
    private long windowSize;
    private long windowStart;
    private int limit;
    private int count;

    public FixedWindowCounter(long windowSizeInSeconds, int limit)
    {
        this.windowSize = windowSizeInSeconds*1000;
        this.limit = limit;
        this.windowStart = System.currentTimeMillis();
        this.count = 0;
    }

    public synchronized boolean allowRequest()
    {
        long now = System.currentTimeMillis();
        if (now - windowStart >= windowSize)
        {
            windowStart = System.currentTimeMillis();
            count = 0;
        }
        if (count == limit) return false;

        count++;
        return true;
    }

    public static void main(String[] args)
    {
        FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(10, 3);
        publishNRequest(fixedWindowCounter, 0, 5, 1);

        // Wait for 5 seconds (for new window)
        try
        {
            System.out.println("Waiting for 5 seconds.....");
            Thread.sleep(5000);
        }
        catch (Exception e)
        {

        }
        publishNRequest(fixedWindowCounter, 5, 10, 1);

    }

    public static void publishNRequest(FixedWindowCounter fixedWindowCounter,
                                       int startId, int endId, int delayInSeconds)
    {
        for(int i = startId; i<endId; i++)
        {
            boolean isAllowed = fixedWindowCounter.allowRequest();
            System.out.print("Request Number - " + i + " - ");

            if(isAllowed)
            {
                System.out.println("Accepted.");
            }
            else{
                System.out.println("429 - Too many request.");
            }

            // Simulate delay
            try {
                Thread.sleep(delayInSeconds * 1000);
            }
            catch(Exception e)
            {

            }
        }
    }
}
