package thread.stop;

/**
 * 场景: 正常地停止线程, 执行被中断后..
 * 业务: 打印10000的倍数的数
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class StopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                int num = 0;
                // 当前线程, 且没有被中断...
                while (num < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()) {
                    if (num % 10000 == 0) {
                        System.out.println("当前数字是1万的倍数" + num);
                    }
                    num++;
                }
                Thread.sleep(5000);
                System.out.println("程序结束..");
            } catch (InterruptedException e) {
                // java.lang.InterruptedException: sleep interrupted
                System.err.println("线程被中断...");
                e.printStackTrace();
            }
        });
        // 线程启动
        thread.start();

        Thread.sleep(1000);

        // 中断线程, 同时需要在线程中编写逻辑
        thread.interrupt();
    }

}
