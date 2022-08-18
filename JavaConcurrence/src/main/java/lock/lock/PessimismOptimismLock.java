package lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 悲观锁和乐观锁
 *
 * @author Jion
 */
public class PessimismOptimismLock {

    /**
     * 悲观锁, 每次只能有一个线程执行此方法
     */
    public synchronized static void pessimismLock() {

    }

    /**
     * 乐观苏, 多个线程之间通过原子类进行区别
     */
    public static void optimismLock() {

        AtomicInteger atomic = new AtomicInteger(1);
        // 原子操作,对当前原子类+1 , 并返回当前值
        int result = atomic.incrementAndGet();
        System.out.println(result);
        System.out.println(atomic);
    }

    public static void main(String[] args) {
        optimismLock();
    }
}
