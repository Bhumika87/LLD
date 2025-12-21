package rateLimiterAlgo.ConcreateAlgoClass;

import rateLimiterAlgo.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter {


    private final int limit;
    private final long windowSize;
    private ConcurrentHashMap<Long, AtomicInteger> windowMap = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }

    @Override
    public boolean allowRequest(String key) {
        long currentWindow = System.currentTimeMillis() / windowSize;
        windowMap.putIfAbsent(currentWindow, new AtomicInteger(0));
        return windowMap.get(currentWindow).incrementAndGet() <= limit;
    }

}
