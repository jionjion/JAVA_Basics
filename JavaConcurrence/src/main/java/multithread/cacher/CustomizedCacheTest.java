package multithread.cacher;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 业务: 测试自己写的缓存安全并发性
 *
 * @author Jion
 */
public class CustomizedCacheTest {

    /**
     * 自己写的缓存类
     */
    static CustomizedCache<String, Integer> cache = new CustomizedCache<>(new UserIdComputeFunction());

    public static void main(String[] args) throws InterruptedException {
        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(1000);

        // 使用倒数门栓进行线程统一执行.. 只需要调用一次 latch.countDown() 完成倒数
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executor.submit(() -> {
                Integer result;
                ThreadLocal<Long> threadLocal = new ThreadLocal<>();
                threadLocal.set(System.currentTimeMillis());
                try {
                    // 门栓倒数
                    System.out.println("开始等待..." + Thread.currentThread().getName());
                    latch.await();
                    System.out.println("被放行..." + Thread.currentThread().getName());
                    result = cache.compute("arg" + finalI);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                Long startTime = threadLocal.get();
                System.out.println("结果: " + result + " ,当前线程用时:" + (System.currentTimeMillis() - startTime));
            });
        }

        // 等待5秒后, 倒数执行
        Thread.sleep(5000L);
        System.out.println("准备放行执行...");
        latch.countDown();

        long startTime = System.currentTimeMillis();
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("总花费时间" + (System.currentTimeMillis() - startTime));
    }
}
