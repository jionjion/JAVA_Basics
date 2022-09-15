package multithread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 场景: 自定义实现 AQS 线程协作器...
 * 业务: 一次性门栓
 *
 * @author Jion
 */
public class OneShotLatch {

    /**
     * 自定义锁
     * 继承自 AbstractQueuedSynchronizer 用来自定义线程管理器你
     * status 1 门栓打开, 0 门栓关闭
     */
    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            // 自定义实现, 获取锁的逻辑... 1 门栓打开; -1 门栓关闭
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            // 自定义实现, 释放锁的逻辑, 将当前状态置为1. 表示门栓打开
            setState(1);
            // 释放锁..
            return true;
        }
    }

    private final Sync sync = new Sync();

    /**
     * 将当前线程,放入等待队列中进行等待
     */
    public void await() {
        // 获取锁, 通过 tryAcquireShared 判断..
        sync.acquireShared(0);
    }

    /**
     * 释放线程, 将当前所有被阻塞的线程进行释放
     */
    public void signal() {
        // 释放锁, 通过 tryReleaseShared 实现
        sync.releaseShared(0);
    }


    public static void main(String[] args) throws InterruptedException {
        // 自定义一次性门栓线程协作器
        OneShotLatch latch = new OneShotLatch();
        // 准备十个子线程, 被阻塞
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("尝试获取门栓...." + Thread.currentThread().getName());
                latch.await();
                System.out.println("门栓放开, 继续执行...." + Thread.currentThread().getName());
            }).start();
        }

        // 休眠5秒后唤醒线程...
        Thread.sleep(5000);
        System.out.println("准备唤醒全部线程...");
        latch.signal();
        // 唤醒后, 一次性门栓不会打开...
        new Thread(() -> {
            System.out.println("尝试获取门栓...." + Thread.currentThread().getName());
            latch.await();
            System.out.println("门栓放开, 继续执行...." + Thread.currentThread().getName());
        }).start();
    }
}
