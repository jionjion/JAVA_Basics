package thread.start;

/**
 * @author Jion
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("当前线程名" + Thread.currentThread().getName());
        // 通过 Runnable.run 启动线程  当前线程名 main
        runnable.run();

        // 通过 Thread.start 启动线程  当前线程名 Thread-0
        Thread thread = new Thread(runnable);
        thread.start();
        // 两次 start 会抛出 IllegalThreadStateException , 非法的线程状态
        // thread.start();

        // 通过 Thread.run 启动线程 当前线程名main
        new Thread(runnable).run();
    }
}
