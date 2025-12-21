import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiterDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("==== TOKEN BUCKET TEST ====");
        testRateLimiter("TOKEN_BUCKET");

        System.out.println("\n==== FIXED WINDOW TEST ====");
        testRateLimiter("FIXED_WINDOW");

        System.out.println("\n==== SLIDING WINDOW TEST ====");
        testRateLimiter("SLIDING_WINDOW");
    }

    private static void testRateLimiter(String algorithm) throws InterruptedException {

        RateLimiterService service = new RateLimiterService(algorithm);

        int totalThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);

        for (int i = 1; i <= 20; i++) {
            final int requestId = i;
            executor.submit(() -> {
                boolean allowed = service.processRequest("user-123");
                System.out.println(
                        "Request-" + requestId +
                                " | Allowed: " + allowed +
                                " | Thread: " + Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
