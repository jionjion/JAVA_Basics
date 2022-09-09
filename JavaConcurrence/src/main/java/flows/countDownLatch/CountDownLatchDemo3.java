package flows.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 门栓演示
 * 场景: 演示同一时刻, 多个线程同时执行
 * 业务: 模拟比赛, 选手准备好后, 所有人同时起泡, 所有人跑步结束后, 完成计时..
 *
 * @author Jion
 */
public class CountDownLatchDemo3 {


    public static void main(String[] args) throws InterruptedException {
        // 一个信号, 一次发令.. 多个线程等一个信号
        CountDownLatch begin = new CountDownLatch(1);

        // 结束, 五名运动员到达重点后.  一个线程等待多个信号
        CountDownLatch end = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("准备完毕, 等待发令枪, " + Thread.currentThread().getName());
                    // 当前线程等待运行
                    try {
                        begin.await();
                        System.out.println("开始跑路了, " + Thread.currentThread().getName());
                        // 模拟跑步时长
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("跑到重点了, " + Thread.currentThread().getName());
                        end.countDown();
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
        begin.countDown();

        // 等待五个人到达重点
        end.await();
        System.out.println("所有人到达重点...");
    }
}
