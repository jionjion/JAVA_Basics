package theadPool;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用 newScheduledThreadPool 创建带有调度任务的线程池
 *
 * @author Jion
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        // 固定线程是的线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // 循环执行线程, 发现线程数量并没有超过5个
        for (int i = 0; i < 1000; i++) {
            // 调度执行, 5秒后执行
            scheduledExecutorService.schedule(new Task(), 5, TimeUnit.SECONDS);
            // 延时1秒后, 每隔3秒执行一次
            scheduledExecutorService.scheduleAtFixedRate(new Task(), 1, 3,  TimeUnit.SECONDS);
        }
        // 关闭
        scheduledExecutorService.shutdown();
    }
}
