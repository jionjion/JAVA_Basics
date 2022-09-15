package multithread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 递归获取资源, 随后拿取资源
 *
 * @author Jion
 */
public class RecursionResource {

    private static final ReentrantLock lock = new ReentrantLock();

    /**
     * 递归调用处理, 通过 getHoldCount() 获取当前持有锁调用的次数
     */
    public static void accessResource() {
        lock.lock();
        try {
            System.out.println("当前线程是否被当前线程持有..." + lock.isHeldByCurrentThread());
            System.out.println("等待当前锁的队列有多长..." + lock.getQueueLength());

            System.out.println("已经对资源进行处理..." + lock.getHoldCount());
            // 资源处理5次, 但是递归时仍然不希望放弃锁...
            if (lock.getHoldCount() <= 5) {
                accessResource();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        accessResource();
    }
}
