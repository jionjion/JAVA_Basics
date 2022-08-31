package atomic;

import lock.spinlock.SpinLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 演示: 原子引用, 在一个操作中完成对对象的赋值和获取操作
 * 业务: 通过对当前线程进行原子引用, 实现当前线程的原子操作
 *
 * @author Jion
 */
public class AtomicReferenceCompareAndSet {

    /**
     * 原子引用
     */
    private AtomicReference<Thread> sign = new AtomicReference<>();

    /**
     * 利用自旋锁定当前线程
     */
    public void lock() {
        // 拿到当前线程
        Thread currentThread = Thread.currentThread();
        // 利用自旋, 将当前 CAS 放入
        while (!sign.compareAndSet(null, currentThread)) {
            System.out.println(currentThread.getName() + "自旋获取失败,再次尝试..");
        }
    }

    /**
     * 解锁当前线程
     */
    public void unlock() {
        Thread currentThread = Thread.currentThread();
        // 将当前原子类进行解锁
        sign.compareAndSet(currentThread, null);
    }


    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        // 线程1, 拿到锁并睡眠
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁...");
            spinLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了自旋锁...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
            }
        }).start();

        // 线程2, 拿到锁并等待后获取锁
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁...");
            spinLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了自旋锁...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
            }
        }).start();
    }

}
