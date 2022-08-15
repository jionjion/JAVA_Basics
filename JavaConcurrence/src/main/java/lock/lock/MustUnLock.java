package lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的标准用法
 * 必须在程序结束后, 在 finally 中释放锁
 *
 * @author Jion
 */
public class MustUnLock {

    /**
     * 锁
     */
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        try {
            // 获取锁,在未获取锁之前会无线等待...处于线程阻塞状态
            LOCK.lock();
            // 抛出异常
            System.out.println("执行业务....");
        } finally {
            // 释放锁
            LOCK.unlock();
        }
    }

}
