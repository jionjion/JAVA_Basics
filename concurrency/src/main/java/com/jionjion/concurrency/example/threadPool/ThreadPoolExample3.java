package com.jionjion.concurrency.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 *	线程池的演示
 *	Executors.newSingleThreadExecutor()		只能执行单个任务,线程顺序为传入线程池的顺序
 */
@Slf4j
public class ThreadPoolExample3 {

	 public static void main(String[] args) {
		
		 //使用带缓存的线程池
		 ExecutorService executorService = Executors.newSingleThreadExecutor();
		 
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
