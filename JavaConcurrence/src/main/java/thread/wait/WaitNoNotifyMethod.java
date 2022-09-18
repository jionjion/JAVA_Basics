package thread.wait;

/**
 * 说明: 线程释放监视器, 只是释放当前类中的
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class WaitNoNotifyMethod {

    static Object monitorA = new Object();
    static Object monitorB = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 线程1 同时加锁多个监视器, 持有监视器A, 释放监视器B
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitorA) {
                    System.out.println(Thread.currentThread().getName() + "获取监视器A");

                    synchronized (monitorB) {
                        System.out.println(Thread.currentThread().getName() + "获取监视器B");

                        try {
                            monitorA.wait();
                            System.out.println(Thread.currentThread().getName() + "释放监视器A, 线程阻塞");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        Thread.sleep(100);

        // 线程2, 尝试获取监视器A, 由于监视器A已经被 awit 释放, 可以获得; 尝试获取B锁, 获取失败... 线程2 阻塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitorA) {
                    System.out.println(Thread.currentThread().getName() + "获取监视器A");

                    synchronized (monitorB) {
                        System.out.println(Thread.currentThread().getName() + "获取监视器B");
                    }
                }
            }
        }).start();

    }
}
