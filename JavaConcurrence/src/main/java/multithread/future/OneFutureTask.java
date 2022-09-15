package multithread.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 场景: 演示 FutureTask 的用法
 *
 * @author Jion
 */
public class OneFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建
        Task task = new Task();
        // 2. 构架
        FutureTask<Integer> futureTask = new FutureTask(task);
        // 3.1 放入线程
        new Thread(futureTask).start();

        Integer integer = futureTask.get();
        System.out.println("获得结果" + integer);

        // 3.2 放入线程池.. 不能再次执行哦..
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(futureTask);
        executor.shutdownNow();

        Integer integer2 = futureTask.get();
        System.out.println("获得结果" + integer2);
    }

    /**
     * 自定义 Callable 任务, 计算一个值
     */
    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            Thread.sleep(10000);
            return new Random().nextInt();
        }
    }
}
