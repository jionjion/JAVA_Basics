package multithread.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示: 公平和不同平两种情况.. <br/>
 * 业务: 循环打印线程
 *
 * @author Jion
 */
public class FairLock {

    static class PrintQueue {
        // true公平锁  false不公平锁
        Lock queueLock = new ReentrantLock(false);

        /**
         * 打印字符串...
         */
        public void print(String str) {
            for (int i = 0; i < 2; i++) {
                // 公平锁: 再获取锁的时候, 根据线程等待队列顺序, 线程[1-10]依次执行;执行一轮之后,再次线程[1-10]依次执行[0,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9]
                // 不公平锁: 再次获取锁的时候, 根据线程当前状态, 已经执行过1次循环的,处于就绪中的线程,继续再次执行...直到10个线程执行完毕[1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9]
                queueLock.lock();
                try {
                    // 打印
                    Long duration = (long) (Math.random() * 10000);
                    System.out.println(Thread.currentThread().getName() + "正在打印 " + str + ", 需要时间 " + (duration / 1000));
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    queueLock.unlock();
                }
            }
        }
    }

    /**
     * 任务函数
     */
    static class Job implements Runnable {

        PrintQueue printQueue;

        public Job(PrintQueue printQueue) {
            this.printQueue = printQueue;
        }


        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始打印...");
            printQueue.print(new Object().toString());
            System.out.println(Thread.currentThread().getName() + "打印完毕....");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 打印队列
        PrintQueue printQueue = new PrintQueue();
        // 创建十个线程
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            // 书序启动,以确定线程顺序
            thread[i] = new Thread(new Job(printQueue));
            Thread.sleep(100);
            thread[i].start();
        }
    }
}
