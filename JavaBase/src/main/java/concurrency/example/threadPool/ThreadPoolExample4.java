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
public class ThreadPoolExample4 {


	public static void main(String[] args) {


		// 使用带缓存的线程池
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		// 线程池,延时10s后执行
		scheduledExecutorService.schedule(new Runnable() {

			@Override
			public void run() {
				log.info("线程调度10s后执行");
			}
		}, 10, TimeUnit.SECONDS);

		// 关闭线程池
		scheduledExecutorService.shutdown();
	}
}
