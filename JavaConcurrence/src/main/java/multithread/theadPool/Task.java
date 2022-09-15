package multithread.theadPool;

/**
 * 打印线程的名字
 *
 * @author Jion
 */
public class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("线程被中断了, " + Thread.currentThread().getName());
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
