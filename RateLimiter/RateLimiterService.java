import rateLimiterAlgo.RateLimiterFactory;
import rateLimiterAlgo.RateLimiter;

public class RateLimiterService {

    private RateLimiter rateLimiter;

    public RateLimiterService(String algorithm) {
        this.rateLimiter = RateLimiterFactory.getRateLimiter(algorithm);
    }

    public boolean processRequest(String userId) {
        return rateLimiter.allowRequest(userId);
    }
}
