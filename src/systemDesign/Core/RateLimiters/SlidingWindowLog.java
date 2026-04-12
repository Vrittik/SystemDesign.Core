package systemDesign.Core.RateLimiters;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog {
    private final long windowSize;
    private final int limit;
    private Queue<Long> requestLog;

    public SlidingWindowLog(long windowSizeInSeconds, int limit)
    {
        windowSize = windowSizeInSeconds*1000;
        this.limit = limit;
        requestLog = new LinkedList<>();
    }

    public synchronized boolean allowRequest()
    {
        long now = System.currentTimeMillis();

        while(!requestLog.isEmpty() && now - requestLog.peek() >= windowSize)
        {
            requestLog.poll();
        }

        if(requestLog.size() < limit)
        {
            requestLog.add(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        SlidingWindowLog slidingWindowLog = new SlidingWindowLog(10, 4);

        // At 1st second - hit 1 request
        publishNRequest(slidingWindowLog, 0, 1, 0);

        try{
            System.out.println("Waiting for 9 seconds....");
            Thread.sleep(9000);
        }
        catch(Exception e)
        {

        }

        // At 9th second - Wait for 9 seconds and hit 3 request (Should allow 3 more request as limit of current window)
        publishNRequest(slidingWindowLog, 1, 4, 0);

        try{
            System.out.println("Waiting for 2 seconds....");
            Thread.sleep(2000);
        }
        catch(Exception e)
        {

        }

        // At 11th second - If it was a fixed window, it would allow 4 request, but now only one request
        // with id 4 will pass (as old entry at 1st second will be removed) and others will be rejected
        publishNRequest(slidingWindowLog, 4, 7, 0);
    }

    public static void publishNRequest(SlidingWindowLog rateLimiter,
                                       int startId, int endId, int delayInSeconds)
    {
        for(int i = startId; i<endId; i++)
        {
            boolean isAllowed = rateLimiter.allowRequest();
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
