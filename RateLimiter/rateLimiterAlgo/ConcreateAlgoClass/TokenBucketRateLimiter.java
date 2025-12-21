package rateLimiterAlgo.ConcreateAlgoClass;

import rateLimiterAlgo.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter implements RateLimiter {

    private final int capacity;

    // tokens per second
    private final int refillRate;

    // current number of tokens and avoids race condition for token count
    private AtomicInteger tokens;
    private long lastRefillTime;

    //ensure refill logic is same so add lock
    private ReentrantLock lock = new ReentrantLock();

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicInteger(capacity);
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    public boolean allowRequest(String key) {
        refill();
        if (tokens.get() > 0) {
            tokens.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refill() {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            long secondsPassed = (now - lastRefillTime) / 1000;
            if (secondsPassed > 0) {
                int newTokens = (int) (secondsPassed * refillRate);
                tokens.set(Math.min(capacity, tokens.get() + newTokens));
                lastRefillTime = now;
            }
        } finally {
            lock.unlock();
        }
    }
}