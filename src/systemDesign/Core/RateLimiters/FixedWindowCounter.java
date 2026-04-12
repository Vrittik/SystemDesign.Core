package systemDesign.Core.RateLimiters;

public class FixedWindowCounter {
    private final long windowSize;
    private long windowStart;
    private final int limit;
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

        // update current count to 0 if new window is encountered
        if (now - windowStart >= windowSize)
        {
            // To know if more than 1 window worth of time has moved
            long windowsMoved = (now - windowStart) / windowSize;

            // Window start only updates at lower boundary, 0s, 5s, 10s, etc...
            windowStart += (windowSize*windowsMoved);
            count = 0;
        }

        if(count < limit)
        {
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(10, 3);
        // Window A
        publishNRequest(fixedWindowCounter, 0, 5, 1);

        // Window B - Wait for 5 seconds (for new window, remaining 5 seconds in current window)
        try
        {
            System.out.println("Waiting for 5 seconds.....");
            Thread.sleep(5000);
            publishNRequest(fixedWindowCounter, 5, 10, 1);
        }
        catch (Exception e)
        {

        }

        // Problem - 2x request at the edges of the windows
        // Window C - Wait for 14 seconds (29th second - End of window C)
        try
        {
            System.out.println("Waiting for 14 seconds.....");
            Thread.sleep(14000);

            // Execute 3 requests simultaneously
            publishNRequest(fixedWindowCounter, 10, 13, 0);
        }
        catch (Exception e)
        {

        }

        // Window D - Wait for 2 seconds (31st second - start of window D)
        try
        {
            System.out.println("Waiting for 2 seconds.....");
            Thread.sleep(2000);

            // Execute 3 requests simultaneously, accepted = 6 request in 2 seconds gap
            // which is the drawback of this. Burst at window edges
            publishNRequest(fixedWindowCounter, 13, 16, 0);
        }
        catch (Exception e)
        {

        }

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
