package thread.stop;

/**
 * 生产最佳实现, 在业务方法前面中抛出 InterruptedException 异常, 去让调用者主动获知线程打断问题
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class StopThreadInProd implements Runnable{


    @Override
    public void run() {
        while(true){
            try {
                // 业务方法, 如果发生了中断, 需要单独写到逻辑
                throwInMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  业务方法, 在业务方法中主动声明, 线程被打断后的业务逻辑
     */
    private void throwInMethod() throws InterruptedException{
        // 休眠10秒
        Thread.sleep(10000);
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadInProd());
        thread.start();

        Thread.sleep(5000);

        // 打断程序执行
        thread.interrupt();
    }
}
