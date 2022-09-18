package thread.wait;

/**
 * 说明: 展示 wait 和 notify 的基本用法
 * synchronized 保证方法只能被一个线程执行, 但不能保证方法的执行顺序, 可能执行到一半被阻塞, 等待被放行
 * wait() 方法会释放监视器锁, 其他线程可以 synchronized 块继续执行...
 * @author Jion
 */
@SuppressWarnings("ALL")
public class WaitMethod {

    /**
     * 充当  synchronized 的  monitor 对象
     */
    static Object monitor = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println("线程1开始执行...");

                    try {
                        // 线程阻塞..  释放 监视器的锁, 其他 synchronized(监视器) 的代码快继续执行
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("线程1" + Thread.currentThread().getName() + "再次获取到了锁...");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println("线程2开始执行...");

                    // 通知 monitor 对象中, 所有监视器中被阻塞的队列继续争抢线程
                    monitor.notify();

                    System.out.println("线程2" + Thread.currentThread().getName() + "调用了notify...");
                }
            }
        });

        // 线程1 首先启动, 获得 monitor 监视器锁后, 知道 wait() 方法, 被暂停, 同时释放 monitor 的锁, 保证线程2可以进入到 synchronized 代码块中
        thread1.start();

        // 短暂休眠后, 线程2 随后启动, 由于线程1已经释放了 monitor 锁, 因此可以继续
        Thread.sleep(200);
        thread2.start();


    }
}
