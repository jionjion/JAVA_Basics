package theadPool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以暂停的线程池
 *
 * @author Jion
 */
public class CanPauseThreadPool extends ThreadPoolExecutor {

    public CanPauseThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public CanPauseThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public CanPauseThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public CanPauseThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    /**
     * 是否被暂停
     */
    private boolean isPaused;

    /**
     * 锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 暂停方法, 在对锁的操作时, 必须使用finally释放
     */
    private void pause() {
        lock.lock();
        try {
            isPaused = true;
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    private Condition unpaused = lock.newCondition();

    /**
     * 在线程执行前, 执行
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        lock.lock();
        try {
            // 如果线程在被挂起
            while (isPaused) {
                // 则让线程挂起
                unpaused.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    /**
     * 恢复方法,将被等待的线程进行唤醒
     */
    public void resume() {
        lock.lock();
        try {
            isPaused = false;
            // 唤醒所有线程
            unpaused.signalAll();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }


    // 测试
    public static void main(String[] args) throws InterruptedException {
        // 自定义,可以暂停的线程池
        CanPauseThreadPool canPauseThreadPool = new CanPauseThreadPool(10, 20, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        // 自定义线程任务
        Runnable runable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我在执行");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 放入到线程池中
        for (int i = 0; i < 1000; i++) {
            canPauseThreadPool.execute(runable);
        }

        Thread.sleep(5000);

        // 暂停
        System.out.println("线程池暂停了");
        canPauseThreadPool.pause();

        Thread.sleep(5000);

        // 恢复
        canPauseThreadPool.resume();
        System.out.println("线程池恢复了");

        // 关闭
        canPauseThreadPool.shutdown();
    }
}