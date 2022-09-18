package thread.exception;

/**
 * 说明: 异常不会处理
 *
 * @author Jion
 */
public class ThreadException {


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

        // 调用子线程, 抛出异常但是不影响主线程执行..
        new Thread(runnable, "线程-1").start();

        // 尝试在主线程调用时, 捕获子线程异常... 无法捕获, 子线程异常无法用传统方法捕获
        try{
            new Thread(runnable, "线程-2").start();
        }catch (Exception e){
            System.out.println("捕获到子线程的异常... ");
            e.printStackTrace();
        }


        new Thread(runnable, "线程-3").start();
        new Thread(runnable, "线程-4").start();


    }
}
