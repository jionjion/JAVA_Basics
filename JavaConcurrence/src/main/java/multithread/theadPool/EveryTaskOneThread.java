package multithread.theadPool;

/**
 * 每个线程执行
 *
 * @author Jion
 */
public class EveryTaskOneThread {

    /**
     *  通过继承 Runnable 实现多线程
     */
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "  执行了子任务");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }
}
