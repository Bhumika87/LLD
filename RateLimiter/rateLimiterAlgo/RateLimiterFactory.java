package rateLimiterAlgo;

import rateLimiterAlgo.ConcreateAlgoClass.FixedWindowRateLimiter;
import rateLimiterAlgo.ConcreateAlgoClass.SlidingWindowRateLimiter;
import rateLimiterAlgo.ConcreateAlgoClass.TokenBucketRateLimiter;
import rateLimiterAlgo.RateLimiter;

public class RateLimiterFactory {

    public static RateLimiter getRateLimiter(String type) {
        switch (type) {
            case "TOKEN_BUCKET":
                return new TokenBucketRateLimiter(10, 2);
            case "FIXED_WINDOW":
                return new FixedWindowRateLimiter(5, 60000);
            case "SLIDING_WINDOW":
                return new SlidingWindowRateLimiter(5, 60000);
            default:
                throw new IllegalArgumentException("Invalid rate limiter type");
        }
    }
}
