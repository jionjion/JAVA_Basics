package thread.wait;

/**
 * 说明: 线程的唤醒操作
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class NotiftyAllMethod {


    static Object monitor = new Object();


    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // wait() 必须在 synchronized 中使用, 确保把锁放到监视器中..
                synchronized (monitor) {
                    System.out.println(Thread.currentThread().getName() + "尝试获取资源... ");
                    try {
                        System.out.println(Thread.currentThread().getName() + "进入等待... ");
                        monitor.wait();
                        System.out.println(Thread.currentThread().getName() + "释放资源... ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println(Thread.currentThread().getName() + "尝试获取资源... ");
                    try {
                        System.out.println(Thread.currentThread().getName() + "进入等待... ");
                        monitor.wait();
                        System.out.println(Thread.currentThread().getName() + "释放资源... ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    // 通知所有线程, notify() 和 notifyAll() 方法必须在 synchronized 代码块中执行, 确保监视器可以被通知..
                    monitor.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "唤醒所有线程.. ");
                }
            }
        }).start();
    }
}
