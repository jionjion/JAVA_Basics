package multithread.flows.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 场景: 模拟信号量的使用
 * 业务: 在多个线程
 *
 * @author Jion
 */
public class SemaphoreDemo {

    /**
     * 信号量, 最大许可证数量为3, 公平锁..
     */
    static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 100; i++) {
            // 虽然线程被提交了50次, 但是许可证限制每次执行最多3次
            executorService.submit(new Task());
        }

        executorService.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                // 当前线程获取一个许可证
                semaphore.acquire();
                System.out.println("线程获取许可证" + Thread.currentThread().getName());

                // 执行一段时间服务
                Thread.sleep(2000);

                System.out.println("线程获释放可证" + Thread.currentThread().getName());
                semaphore.release();

                // 释放许可证
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
