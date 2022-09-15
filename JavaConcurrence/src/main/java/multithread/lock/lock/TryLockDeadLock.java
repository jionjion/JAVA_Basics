package multithread.lock.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 tryLock 避免死锁... 当 tryLock 失败后, 轮训或者继续处理
 *
 * @author Jion
 */
public class TryLockDeadLock implements Runnable {

    /**
     * 争抢资源, 需要修改的的标志位
     */
    int flag = 0;

    /**
     * 锁1, 静态变量. 所有实例共有.
     */
    static Lock lock1 = new ReentrantLock();

    /**
     * 锁2. 静态变量. 所有实例共有.
     */
    static Lock lock2 = new ReentrantLock();

    /**
     * 必须同时拿到锁1和锁2后,才算执行完毕..
     * 如果任意线程,在获取锁1和锁2失败后, 调用 tryLock 的默认方法, 输出语句后继续 while 循环处理
     * 直到所有线程都拿到所需要的两把锁, 执行完成..
     */
    @Override
    public void run() {
        // 循环获取锁
        while (true) {
            // 如果状态1
            if (flag == 1) {
                try {
                    // 尝试获取锁1
                    if (lock1.tryLock(800, TimeUnit.SECONDS)) {
                        // 获取锁1后, 修改状态
                        try {
                            // 获取1锁后,携带1秒
                            System.out.println("线程1 拿到了锁一");
                            Thread.sleep(new Random().nextInt(1000));
                            // 尝试获取锁2
                            if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    // 获取2把锁...并处理业务逻辑
                                    System.out.println("线程1 拿到了锁二.... 执行需要的逻辑");

                                    // 拿到锁二后, 跳出训话
                                    break;
                                } finally {
                                    lock2.unlock();
                                }
                            } else {
                                System.out.println("线程1 获取锁二 失败...重试");

                            }
                        } finally {
                            // 必须在 finally 中释放锁
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        // 获取失败, 循环
                        System.out.println("线程1 获取锁一 失败...重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                // 第二种情况
                try {
                    // 尝试获取锁2
                    if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                        // 获取锁后, 修改状态
                        try {
                            // 获取锁1后,携带1秒
                            System.out.println("线程2 拿到了锁二");
                            Thread.sleep(new Random().nextInt(1000));

                            // 尝试获取锁1
                            if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    // 获取2把锁...并处理业务逻辑
                                    System.out.println("线程2 拿到了锁一.... 执行需要的逻辑");

                                    // 拿到锁二后, 跳出训话
                                    break;
                                } finally {
                                    lock1.unlock();
                                }
                            } else {
                                // 获取失败, 循环
                                System.out.println("线程2 获取锁一 失败...重试");
                            }
                        } finally {
                            // 必须在 finally 中释放锁
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程2 获取锁二 失败...重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLockDeadLock thread1 = new TryLockDeadLock();
        TryLockDeadLock thread2 = new TryLockDeadLock();

        // 为成员变量赋值, 具有相反结构
        thread1.flag = 0;
        thread2.flag = 1;

        // 执行线程
        new Thread(thread1).start();
        new Thread(thread2).start();


    }
}
