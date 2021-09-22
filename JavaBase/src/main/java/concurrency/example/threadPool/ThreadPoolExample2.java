package concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *	线程池的演示
 *	Executors.newFixedThreadPool(5)		获得固定容量的线程池
 *	同一时刻最多只有5个线程可以执行任务
 */
@Slf4j
public class ThreadPoolExample2 {

	 public static void main(String[] args) {
		
		 //使用带缓存的线程池
		 ExecutorService executorService = Executors.newFixedThreadPool(5);
		 
		 //将任务放入线程池
		 for(int i=0 ; i<10 ; i++) {
			 final int j = i;
			 executorService.execute(new Runnable() {
				//定义执行的线程任务
				@Override
				public void run() {
					log.info("线程{},执行",j);
				}
			});
		 }
		 
		 //关闭线程池
		 executorService.shutdown();
	}
}
