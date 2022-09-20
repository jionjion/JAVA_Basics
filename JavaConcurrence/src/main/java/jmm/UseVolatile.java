package jmm;

/**
 * 说明: 演示 volatile 对布尔标志的赋值动作
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class UseVolatile {

    static volatile boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        // 循环1万次, 验证多线程情况下对 volatile 关键字修饰的变量不能保证自增操作的原子性..
        for (int i = 0; i < 10000; i++) {
            // 线程1
            Thread thread1 = new Thread(() -> {
                // 原子操作, 赋值是原子操作
                flag = false;
            });

            // 线程2
            Thread thread2 = new Thread(() -> {
                // 原子操作, 赋值是原子操作
                flag = true;
            });
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
            System.out.println("flag: " + flag);
        }
    }
}
