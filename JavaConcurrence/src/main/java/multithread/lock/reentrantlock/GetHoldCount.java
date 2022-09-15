package multithread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 获取可重入锁当前获取的次数
 * 每次加锁或者释放锁, 会将当前可重入锁的持有次数+1/-1
 *
 * @author Jion
 */
public class GetHoldCount {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("当前锁已经被拿了: " + lock.getHoldCount()); // 0
        lock.lock();
        System.out.println("当前锁已经被拿了: " + lock.getHoldCount()); // 1

        lock.lock();
        System.out.println("当前锁已经被拿了: " + lock.getHoldCount()); // 2

        lock.unlock();
        System.out.println("当前锁已经被拿了: " + lock.getHoldCount());// 1

        lock.unlock();
        System.out.println("当前锁已经被拿了: " + lock.getHoldCount());// 0
    }

}
