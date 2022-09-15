package multithread.aqs;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Jion
 */
public class AQSDemo {

    public static void main(String[] args) {
        // 信号量
        new Semaphore(1);
        // 门栓倒数
        new CountDownLatch(1);
        // 可重入锁
        new ReentrantLock();
    }
}
