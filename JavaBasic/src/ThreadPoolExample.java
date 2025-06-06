import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    // Thread pool for handling HTTP requests (simulated)
    private static ExecutorService httpRequestPool = Executors.newFixedThreadPool(50);

    // Thread pool for background order processing tasks
    private static ExecutorService orderProcessingPool = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        // Simulate submitting a task to HTTP thread pool
        httpRequestPool.submit(() -> {
            System.out.println("Handling HTTP request in thread " + Thread.currentThread().getName());
        });

        System.out.println("hello  "+ Thread.currentThread());
        // Simulate submitting a task to order processing thread pool
        orderProcessingPool.submit(() -> {
            System.out.println("Processing order in thread " + Thread.currentThread().getName());
        });

        // Shutdown pools gracefully (in real apps, usually on app shutdown)
        httpRequestPool.shutdown();
        orderProcessingPool.shutdown();
    }
}
