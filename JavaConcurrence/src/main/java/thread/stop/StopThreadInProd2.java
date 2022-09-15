package thread.stop;

/**
 * 生产最佳实现, 在业务方法中, 自行处理异常...并标记当前异常为被打断...
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class StopThreadInProd2 implements Runnable {


    @Override
    public void run() {
        while (true) {
            // 检查当前线程是否被中断...
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序被打断...");
                break;
            }

            // 业务方法, 如果发生了中断, 需要单独写到逻辑
            reInterrupt();
        }
    }

    /**
     * 业务方法, 在业务方法中捕获异常, 并将当前线程标记为被中断
     */
    private void reInterrupt() {
        // 休眠10秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // 恢复设置当前异常为中断状态
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadInProd2());
        thread.start();

        Thread.sleep(5000);

        // 打断程序执行
        thread.interrupt();
    }
}
