package multithread.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示: 锁的升级
 * 业务: 在读锁和写锁存在时, 对锁进行升级
 *
 * @author Jion
 */
public class CinemaReadWriteUpgrading {

    // 读写锁
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    // 读写锁中的读锁
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    // 读写锁中写锁
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    /**
     *  锁的升级
     */
    private static void readUpgrading() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁...");
            Thread.sleep(1000);
            System.out.println("升级会带来阻塞");
            // 读锁不能升级为写锁...
            writeLock.lock();
            System.out.println("成功获取到写锁.. 升级成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了读锁...");
            readLock.unlock();
        }
    }

    /**
     *  锁的降级
     */
    private static void writeDowngrading() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁...正在写入");
            Thread.sleep(1000);
            System.out.println("锁的降级");
            readLock.lock();
            System.out.println("在不释放写锁的情况下, 拿到读锁.. 成功降级");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了写锁...");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        // 写锁降级....
        new Thread(()-> writeDowngrading(), "Thread-Write1").start();
        // 读锁升级.... 不可以
        new Thread(()-> readUpgrading(), "Thread-Read1").start();
    }
}
