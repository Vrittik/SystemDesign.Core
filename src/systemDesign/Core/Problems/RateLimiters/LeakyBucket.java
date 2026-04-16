package systemDesign.Core.Problems.RateLimiters;

public class LeakyBucket {
    private final int capacity;
    private int currentSize;
    private final double leakPerMs;
    private long lastLeakTimeMs;

    public LeakyBucket(int capacity, int requestLeakPerSecond)
    {
        this.capacity = capacity;
        this.leakPerMs = (double) (requestLeakPerSecond) / 1000.0;
        this.currentSize = 0;
        this.lastLeakTimeMs = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest()
    {
        // Calculate and leak the bucket
        long now = System.currentTimeMillis();
        int requestsLeakedTillNow = (int) ((now - lastLeakTimeMs)*leakPerMs);
        if(requestsLeakedTillNow > 0)
        {
            lastLeakTimeMs += (long) (requestsLeakedTillNow/leakPerMs);
            if(requestsLeakedTillNow > currentSize)
            {
                // We are counting the leak and currentSize should not go negative
                currentSize = 0;
            }
            else {
                currentSize -= requestsLeakedTillNow;
            }
        }

        if(currentSize < capacity)
        {
            currentSize++;
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        LeakyBucket leakyBucket = new LeakyBucket(6, 2);

        // At 1st second - hit 4 request simultaneously
        publishNRequest(leakyBucket, 0, 4, 0);

        try{
            System.out.println("Waiting for 1 seconds....");
            Thread.sleep(1000);
        }
        catch(Exception e)
        {

        }


        // At 1st second - 2 requests are already executed, so 2 are left in the bucket
        // Now we add 4 more. So queue will be full at the end of 1st second with 6 request
        publishNRequest(leakyBucket, 4, 8, 0);

        try{
            System.out.println("Waiting for 1 seconds....");
            Thread.sleep(1000);
        }
        catch(Exception e)
        {

        }

        // At 2nd second - 2 request will be executed and there will be 4 left in the queue
        // Now we add 4 more request. Two will add and two will say 429.
        publishNRequest(leakyBucket, 8, 12, 0);
    }

    public static void publishNRequest(LeakyBucket rateLimiter,
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
