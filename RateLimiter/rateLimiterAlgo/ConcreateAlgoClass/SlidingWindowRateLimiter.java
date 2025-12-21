package rateLimiterAlgo.ConcreateAlgoClass;

import rateLimiterAlgo.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRateLimiter implements RateLimiter {

    private final int limit;
    private final long windowSize;
    private Queue<Long> timestamps = new ConcurrentLinkedQueue<>();

    public SlidingWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }



    @Override
    public synchronized boolean allowRequest(String key) {
        long now = System.currentTimeMillis();
        while (!timestamps.isEmpty() && timestamps.peek() < now - windowSize) {
            timestamps.poll();
        }
        if (timestamps.size() < limit) {
            timestamps.add(now);
            return true;
        }
        return false;
    }
}
