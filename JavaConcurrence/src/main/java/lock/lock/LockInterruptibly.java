package lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以被打断的锁..
 *
 * @author Jion
 */
public class LockInterruptibly implements Runnable {

    static Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        Thread thread1 = new Thread(new LockInterruptibly());
        Thread thread2 = new Thread(new LockInterruptibly());

        thread1.start();
        thread2.start();

        // 线程启动后, 打断线程
        thread2.interrupt();
    }


    @Override
    public void run() {
        System.out.println("尝试获取锁: " + Thread.currentThread().getName());

        try {
            // 锁, 可以在解锁期间
            lock.lockInterruptibly();
            // 标准写法,在锁后必须跟上try执行业务逻辑和finally释放锁
            try {
                System.out.println("获取锁后, 业务逻辑.....");
                // 休眠等一会
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("睡眠期间被中断..");
                }
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("获得锁期间被中断..");
        }
    }
}
