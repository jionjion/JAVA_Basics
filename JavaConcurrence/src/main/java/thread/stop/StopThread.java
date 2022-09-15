package thread.stop;

/**
 * 场景: 正常地停止线程
 * 业务: 打印10000的倍数的数
 *
 * @author Jion
 */
public class StopThread implements Runnable {

    @Override
    public void run() {
        int num = 0;
        // 当前线程, 且没有被中断...  通过在费时循环中, 判断当前线程是否被停止 Thread.currentThread().isInterrupted()
        while (num < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()) {
            if (num % 10000 == 0) {
                System.out.println("当前数字是1万的倍数" + num);
            }
            num++;
        }
        System.out.println("程序结束..");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();

        Thread.sleep(1000);

        // 中断线程, 同时需要在线程中编写逻辑
        thread.interrupt();
    }

}
