package thread.field;

/**
 * @author Jion
 */
@SuppressWarnings("ALL")
public class ThreadField {

    public static void main(String[] args) {

        // 主线程ID, 永远为1
        Thread main = Thread.currentThread();
        System.out.println("主线程ID: " + main.getId());

        // 子线程ID, 默认在创建时会有很多奇奇怪怪的线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
        // 设置名字
        thread.setName("子线程的名字");
        // 设置守护进程
        thread.setDaemon(true);
        // 设置优先级, 10最高
        thread.setPriority(10);
        System.out.println("子线程ID: " + thread.getId());
        thread.start();
    }
}
