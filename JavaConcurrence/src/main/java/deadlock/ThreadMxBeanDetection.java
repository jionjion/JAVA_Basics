package deadlock;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 说明: 使用 ThreadMxBean 检测死锁
 *
 * @author Jion
 */
public class ThreadMxBeanDetection implements Runnable {


    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    int flag = 1;

    public static void main(String[] args) throws InterruptedException {
        MustDeadLock dome1 = new MustDeadLock();
        MustDeadLock dome2 = new MustDeadLock();
        dome1.flag = 0;
        dome2.flag = 1;
        Thread thread1 = new Thread(dome1);
        Thread thread2 = new Thread(dome2);
        // 子线程启动..
        thread1.start();
        thread2.start();

        // 死锁发生后
        Thread.sleep(1000);

        // 获取 ThreadMXBean 对象
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 所有线程发生死锁的线程数量
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        // 循环所有线程
        if(deadlockedThreads != null && deadlockedThreads.length > 0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                // 获得发生死锁的线程信息
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println("发现死锁" + threadInfo.getThreadName());
            }
        }
    }

    @Override
    public void run() {
        System.out.println("flag" + flag);
        if (flag == 0) {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {
                    System.out.println("线程1拿到了两把锁!");
                }
            }
        }
        if (flag == 1) {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1) {
                    System.out.println("线程2拿到了两把锁!");
                }
            }
        }
    }
}
