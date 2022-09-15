package multithread.theadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用 newCachedThreadPool 创建可以缓存的线程池
 *
 * @author Jion
 */
public class CacheThreadPoolTest {

    public static void main(String[] args) {
        // 固定线程是的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 循环执行线程, 发现线程数量并没有超过5个
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }

        // 关闭
        executorService.shutdown();
    }


}
