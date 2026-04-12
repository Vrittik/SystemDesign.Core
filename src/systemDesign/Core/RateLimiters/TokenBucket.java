package systemDesign.Core.RateLimiters;

public class TokenBucket {
    private final int limit;
    private final double refillRate;
    private int tokens;
    private long startTime;

    public TokenBucket(int limit, int initialTokens, int refillCount, int refillInSeconds)
    {
        this.limit = limit;
        refillRate = (double) refillCount / (double) (refillInSeconds * 1000); // refill rate per ms
        tokens = initialTokens;
        startTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest()
    {
        // Perform refill
        long now = System.currentTimeMillis();
        int tokensToAdd = (int)((now - startTime)*refillRate);
        if(tokensToAdd > 0)
        {
            // only fill up to a particular limit
            tokens = Math.min(limit, tokens + tokensToAdd);

            // reset start time if token refill has happened, denoting new startTime for later refills
            // We do this as we need to move startTime to the actual time where last bucket filling
            // happened. For example - lets say 2 tokens needed to be added and refill rate was
            // 1 token per 2 second. And initial startTime was 0
            // Now after 4 seconds, 2 tokens will be added. So the last time the token
            // was appended was at 4 seconds
            // So we need to move startTime += (2 (new tokens) / 0.5) (as refill rate is 0.5 (1/2) per second)
            // So new startTime = 4 seconds = 4000 ms if we take refillRate per ms
            // which makes sense.
            startTime += (long) (tokensToAdd/refillRate);
        }

        if(tokens > 0)
        {
            tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        TokenBucket tokenBucket = new TokenBucket(5, 3, 1, 2);

        publishNRequest(tokenBucket, 0, 7, 1);

        // at -1 seconds = total tokens = 3
        // at 0 seconds = total tokens = 2 (1 used by request 0)
        // at 1 seconds = total tokens = 1 (1 used by request 1)
        // at 2 seconds = total tokens = 1 (1 refilled and 1 used by request 2)
        // at 3 seconds = total tokens = 0 (1 used by request 3)
        // at 4 seconds = total tokens = 0 (1 refilled and 1 used instantly by request 4)
        // at 5 seconds = total tokens = 0 (request 5 fails)
        // at 6 seconds = total tokens = 0 (1 refilled and 1 used instantly by request 6)

        // Wait for 10 seconds to refill and execute 5 burst requests
        try
        {
            System.out.println("Waiting for 10 seconds to let the bucket refill completely");
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {

        }
        publishNRequest(tokenBucket, 7, 12, 0);
    }

    public static void publishNRequest(TokenBucket rateLimiter,
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
