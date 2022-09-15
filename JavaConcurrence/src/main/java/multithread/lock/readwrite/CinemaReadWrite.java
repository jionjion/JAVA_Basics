package multithread.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示: 对读写锁的使用, 及不同顺序下的执行情况
 * 业务: 电影院案例
 *
 * @author Jion
 */
public class CinemaReadWrite {

    // 读写锁
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    // 读写锁中的读锁
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    // 读写锁中写锁
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();


    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了读锁...");
            readLock.unlock();
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁...正在写入");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了写锁...");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        // 使用读写锁, 读锁可以在拿到后直接方式
        new Thread(()-> read(), "Thread-Read1").start();
        new Thread(()-> read(), "Thread-Read2").start();
        // 写锁需要在一个线程结束后,再执行下一个线程
        new Thread(()-> write(), "Thread-Write1").start();
        new Thread(()-> write(), "Thread-Write2").start();
        new Thread(()-> write(), "Thread-Write3").start();
    }
}
