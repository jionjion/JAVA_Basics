package thread.status;

/**
 * 场景: 描述线程的状态, 展示线程 blocked, waiting, timed waiting 状态
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class ThreadStatus2 {

    public synchronized void sync() {
        try {
            Thread.sleep(1000);
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            new ThreadStatus2().sync();
        });

        Thread thread2 = new Thread(() -> {
            new ThreadStatus2().sync();
        });
        thread1.start();
        thread2.start();

        Thread.sleep(10);

        // 线程1, TIMED_WAITING 等待睡眠结束
        System.out.println("线程1 状态 " + thread1.getState());

        // 线程2, 等待获得 synchronized 修饰的锁的状态 BLOCKED
        System.out.println("线程2 状态 " + thread2.getState());

        // 线程1 休眠后进入 wait() 方法, 进入到等待状态  WAITING
        Thread.sleep(1200);
        System.out.println("线程1 状态 " + thread1.getState());

    }
}
