package flows.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 场景: 演示  CyclicBarrier 操作
 * 业务: 当五个线程完成任务后, 统一执行下一个任务
 *
 * @author Jion
 */
public class CyclicBarrierDemo1 {

    public static void main(String[] args) {

        // 需要等待完成的线程总数, 5个,  当所有线程凑齐后, 执行线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("这一波人到场了....");
            }
        });

        // 创建多个线程, 执行..
        for (int i = 0; i < 10; i++) {
            // 多个线程各自执行任务, 等凑够5个后, 再执行 循环栅栏 中定义的线程.....   依次轮流
            new Thread(new Task(i, cyclicBarrier)).start();
        }

    }

    /**
     *
     */
    static class Task implements Runnable {

        private int id;

        private CyclicBarrier cyclicBarrier;

        public Task(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程" + id + "前往集合地点");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("线程" + id + "到了集合地点, 开始等待其他人到达..");

                // 等五个线程到达后... 循环栅栏 继续执行
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
