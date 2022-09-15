package multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 演示: 线程安全的数组, 对线程内的每个原子类都保证原子性
 * 业务: 在多线程环境下, 对同一个 static 的原子数组进行操作
 * <p>
 * 多线程下原子类数组
 *
 * @author Jion
 */
public class AtomicIntegerArrayIncrement implements Runnable {
    public static final AtomicIntegerArray instance = new AtomicIntegerArray(100);

    /**
     * 自增
     */
    public static void increment() {
        for (int i = 0; i < instance.length(); i++) {
            instance.incrementAndGet(i);
        }
    }

    /**
     * 自减
     */
    public static void decrement() {
        for (int i = 0; i < instance.length(); i++) {
            instance.decrementAndGet(i);
        }
    }

    @Override
    public void run() {
        // 同时自增自驾
        increment();
        decrement();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArrayIncrement demo = new AtomicIntegerArrayIncrement();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(demo);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            // 等待线程完成
            threads[i].join();
        }

        // 原子数组的值
        System.out.println(instance);
    }


}


