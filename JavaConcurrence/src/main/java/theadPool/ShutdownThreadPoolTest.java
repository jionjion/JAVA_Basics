package theadPool;

import java.util.List;
import java.util.concurrent.*;

/**
 * 关闭线程池
 *
 * @author Jion
 */
public class ShutdownThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        // 固定线程是的线程池
        ExecutorService executorService = new ThreadPoolExecutor(5, 100, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

        // 循环执行线程, 发现线程数量并没有超过5个
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }

        // 关闭
        executorService.shutdown();
        // 判断是否关闭
        System.out.println("线程是否关闭" + executorService.isShutdown());
        // 判断是否完全关闭
        System.out.println("线程是否完全关闭" +executorService.isTerminated());
        // 等待一段时间, 如果当前10秒后还未关闭, 返回 False
        System.out.println("线程是否在10秒内关闭" + executorService.awaitTermination(10, TimeUnit.SECONDS));
        // 立刻关闭线程池. 并将未执行的线程任务返回.. 如果线程被中断了, 抛出 java.lang.InterruptedException 异常
        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println("线程立即停止, 当前剩余 " + runnables.size());
    }
}
