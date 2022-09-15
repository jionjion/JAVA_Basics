package multithread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * 演示: LongAdder 计时打印, 耗时更短
 *
 * @author Jion
 */
public class LongAdderDemo {

    public static void main(String[] args) {
        LongAdder counter = new LongAdder();

        ExecutorService executor = Executors.newFixedThreadPool(20);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executor.submit(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    // 定义多线程任务, 自加 +1
                    counter.add(1);
                }
            });
        }

        // 线程池关闭
        executor.shutdown();
        // 等待线程关闭, 循环
        while (!executor.isTerminated()) {
        }

        // 输出结果
        System.out.println(counter.sum());
        System.out.println("AtomicLong用时: " + (System.currentTimeMillis() - start));
    }
}
