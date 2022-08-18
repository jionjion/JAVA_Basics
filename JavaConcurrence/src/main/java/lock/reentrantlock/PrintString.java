package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用  ReentrantLock 类去锁定资源.当锁定被打断时, 发生异常..
 * 代码演示预定电影票类
 *
 * @author Jion
 */
public class PrintString {


    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 字符串打印, 一个个打印.. 静态方法, 提供给不同线程间调用
     */
    private static void output(String name) {
        int length = name.length();
        lock.lock();
        try {
            for (int i = 0; i < length; i++) {
                System.out.println(name.charAt(i));
            }
            System.out.println("\n");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // 打印, 只有一个线程打印完成后,另一个线程才可以打印输出...避免打印时序号混乱

        // 线程1
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                output("床前明月光");
            }
        }).start();

        // 线程2
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                output("疑是地上霜");
            }
        }).start();
    }
}
