package multithread.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 场景: 演示 Future 接口的用法
 *
 * @author Jion
 */
public class OneFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 执行任务类, 并获得返回 Future 对象
        Future<Integer> futureA = executor.submit(new Task());

        // 在未获得返回值时, 线程会阻塞
        System.out.println("尝试获取返回值..." + futureA.get());
        System.out.println("任务是否完成" + futureA.isDone());

        // 使用 Lambda 表达式构建, 并打断..
        Future<Integer> futureB = executor.submit(() -> {
            Thread.sleep(10000);
            return new Random().nextInt();
        });
        // 是否中断正在执行的任务..
        boolean cancel = futureB.cancel(true);
        System.out.println("打断当前任务..." + cancel);
        System.out.println("任务是被打断" + futureB.isCancelled());
        System.out.println("任务是否完成" + futureA.isDone());
        // 打断后再获取会抛出异常 java.util.concurrent.CancellationException
        futureB.get();
        // 设置获取超时时间, 超时后抛出 java.util.concurrent.TimeoutException
        futureB.get(1, TimeUnit.MILLISECONDS);

        executor.shutdown();
    }

    /**
     * 任务类, 通过实现  Callable 方法完成
     */
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(10000);
            return new Random().nextInt();
        }
    }
}
