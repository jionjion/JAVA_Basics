package concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *	线程池的演示
 *	Executors.newScheduledThreadPool()	具有调度功能的线程池
 *	
 */
@Slf4j
public class ThreadPoolExample5 {

	public static void main(String[] args) {

		// 使用带缓存的线程池
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		// 以指定的速率完成线程
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				log.info("线程调度,延迟10s后每1s进行执行");
			}
			// 延迟10s后,以3秒为间隔执行
		}, 10, 3, TimeUnit.SECONDS);
		
		// 这里不需要关闭线程池
	}
}
