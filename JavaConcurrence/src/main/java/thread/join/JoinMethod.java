package thread.join;

/**
 * 说明: 演示 join 线程加入用法..
 * 业务: 子线程中中断主线程, 则 join 时抛出 InterruptedException 异常, 主线程捕获的同时, 通知子线程进行 interrupt()..
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class JoinMethod {

    public static void main(String[] args) {

        // 主线程打断
        Thread main = Thread.currentThread();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // join时, 主线程状态 WAITING
                System.out.println("主线程状态" + main.getState());

                System.out.println("子线程执行...");
                try {
                    Thread.sleep(10000);
                    // 主线程中断
                    main.interrupt();
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("子线程被中断...");
                }
            }
        });

        thread.start();
        // 子线程加入到主线程
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("主线程被中断, 抛出异常..." + Thread.currentThread().getName());
            // 主线程中断时, 通知子线程中断
            thread.interrupt();
        }
        System.out.println("所有执行完毕,,,");
    }
}
