package com.jionjion.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.junit.Test;

/**
 * 	线程不安全的测试
 */
public class HelloControllerTest {

	//请求次数
	public static int clientTotal = 5000;
	
	//线程
	public static int threadTotal = 20;
	
	@Test
	public void testSayHello() {
		
		//线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//信号量,允许并发数目
		Semaphore semaphore = new Semaphore(threadTotal);
		
		//计数器
		CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		
		//将每个线程放入线程池
		for (int i = 0; i < clientTotal; i++) {
			//执行函数,这里采用匿名函数写法
			executorService.execute(() -> {
				try {
					//是否允许执行
					semaphore.acquire();
					add();
					//释放进程
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//执行完成后,计数-1
				countDownLatch.countDown();
			});
		}
		
		try {
			//线程都归零,结束
			countDownLatch.await();
			//结束
			executorService.shutdown();
			System.out.println("执行总次数:" + sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 定义业务方法
	public static int sum = 0;
	public static void add() {
		sum ++;
	}

}
