package multithread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 演示: AtomicLong 计时打印, 耗时
 *
 * @author Jion
 */
public class AtomicLongDemo {

    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(0);

        ExecutorService executor = Executors.newFixedThreadPool(20);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executor.submit(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    // 定义多线程任务, 自加 +1
                    counter.getAndIncrement();
                }
            });
        }

        // 线程池关闭
        executor.shutdown();
        // 等待线程关闭, 循环
        while (!executor.isTerminated()) {
        }

        // 输出结果
        System.out.println(counter);
        System.out.println("AtomicLong用时: " + (System.currentTimeMillis() - start));
    }
}
