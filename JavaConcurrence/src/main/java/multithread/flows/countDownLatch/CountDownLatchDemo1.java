package multithread.flows.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 门栓演示
 * 场景: 演示门栓倒计, 一个主线程等待多个线程执行完毕后, 再继续主线程的工作
 * 业务: 模拟检测动作, 当所有的检测通过才可以执行下一步
 *
 * @author Jion
 */
public class CountDownLatchDemo1 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        // 创建线程池, 一次提交多个
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 提交任务
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            Runnable runnable = () -> {
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("线程处理完成工作.. " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 计数 -1
                    countDownLatch.countDown();
                }
            };
            // 提交任务到线程池
            executorService.submit(runnable);
        }
        // 提交任务完成后,输出
        System.out.println("等待五个人检查完毕...");
        // 等嗲任务完成, 此事主线程阻塞, 等所有的线程池任务完成后继续
        countDownLatch.await();
        System.out.println("所有人都完成了工作");
    }
}
