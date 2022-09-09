package flows.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 门栓演示
 * 场景: 演示同一时刻, 多个线程同时执行
 * 业务: 模拟比赛, 选手准备好后, 所有人同时起泡
 *
 * @author Jion
 */
public class CountDownLatchDemo2 {


    public static void main(String[] args) throws InterruptedException {
        // 一个信号, 一次发令
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("准备完毕, 等待发令枪");
                    // 当前线程等待运行
                    try {
                        latch.await();
                        System.out.println("开始跑路了, " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }

        // 裁判准备...
        Thread.sleep(5000);
        System.out.println("比赛开始");
        // 门栓消失, 同时执行... 多等一
        latch.countDown();
    }
}
