package thread.status;

/**
 * 场景: 描述线程的状态, 展示线程 new  runnable terminated 状态
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class ThreadStatus1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        });

        // 线程状态  NEW
        System.out.println("线程新建状态: " + thread.getState());

        // 线程执行  RUNNABLE
        thread.start();
        System.out.println("线程可运行状态: " + thread.getState());
        Thread.sleep(10);
        //即使是线程正在运行中  RUNNABLE
        System.out.println("线程可运行状态: " + thread.getState());
        // 新建的子线程加入的主线程中
        thread.join();
        // 线程运行结束  TERMINATED
        System.out.println("线程结束运行:" + thread.getState());
    }
}
