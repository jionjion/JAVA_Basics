package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示: 原子类的基本用法...
 * 业务: 多线程下对 static 静态常量累合, 线程安全与不安全的操作
 *
 * @author Jion
 */
public class AtomicIntegerIncrement implements Runnable {

    /**
     * 基本方法
     */
    public void test() {

        AtomicInteger i = new AtomicInteger();
        // 设置当前值
        i.set(1);
        // 获取当前值
        i.get();
        // 自增并返回值
        i.getAndIncrement();
        // 自减并返回值
        i.getAndDecrement();
        // 获取当前值,并自增 2
        i.getAndAdd(2);
        // 当前值是否为期待值 10, 如果是, 更新为20
        i.compareAndSet(10, 20);
    }

    /**
     * 原子类
     */
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    /**
     * 原子类自增
     */
    public void atomicIncrement() {
        // 增
        ATOMIC_INTEGER.getAndIncrement();
    }

    /**
     * 基本数据类型. volatile 禁止指令排序和保持内存可见性
     */
    private static volatile int basicInteger = 0;

    /**
     * 基本数据类型自增..
     * 如果通过添加 synchronized 关键字也可以保证线程安全
     */
    public void basicIncrement() {
        basicInteger++;
    }

    @Override
    public void run() {
        // 使用多线程, 对类成员变量进行自增操作
        for (int i = 0; i < 100000L; i++) {
            // 基础类自增
            basicIncrement();
            // 原子类自增
            atomicIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerIncrement demo = new AtomicIntegerIncrement();
        // 普通变量和原子类, 在多线程情况下, 对累计求和的线程安全性
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("原子类求和" + AtomicIntegerIncrement.ATOMIC_INTEGER);
        System.out.println("基本类求和" + AtomicIntegerIncrement.basicInteger);
    }
}
