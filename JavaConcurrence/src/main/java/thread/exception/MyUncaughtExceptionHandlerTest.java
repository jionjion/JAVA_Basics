package thread.exception;

/**
 * 说明: 使用自已的自定义异常处理器
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class MyUncaughtExceptionHandlerTest {

    public static void main(String[] args) {
        // 在线程执行中, 抛出异常..
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    throw new RuntimeException(Thread.currentThread().getName() + "抛出了异常");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 设置全局的异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        // 调用会抛出异常的线程
        new Thread(runnable, "线程-1").start();

        Thread thread2 = new Thread(runnable, "线程-2");
        // 每个线程单独设置
        thread2.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread2.start();
    }
}
