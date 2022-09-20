package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 说明: 演示不适合 volatile 的场景
 *   volatile 仅能保证读数据的可见性, 但是不能保证操作的原子性... 因此还是要对非原子操作进行 synchronized 加锁处理
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class NoVolatile {

    static volatile int a = 0;
    static AtomicInteger b = new AtomicInteger(0);
    static volatile int c = 0;


    public static void main(String[] args) throws InterruptedException {
        // 循环1万次, 验证多线程情况下对 volatile 关键字修饰的变量不能保证自增操作的原子性..
        for (int i = 0; i < 10000; i++) {
            // 线程1 自增
            Thread thread1 = new Thread(() -> {
                a = a + 1;
                b.getAndIncrement();

                // 加锁,保证 自增 原子性
                synchronized (NoVolatile.class) {
                    c++;
                }
            });

            // 线程2 自增
            Thread thread2 = new Thread(() -> {
                a = a + 1;
                b.getAndIncrement();

                // 加锁,保证 自增 原子性
                synchronized (NoVolatile.class) {
                    c++;
                }
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println("a: " + a + " , b: " + b + " , c: " + c);
        }
    }
}
