package com.jionjion.concurrency.example.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.extern.slf4j.Slf4j;

/**
 *	使用CyclicBarrier类
 *	完成对规定时间内执行方法的调用
 */
@Slf4j
public class CyclicBarrierExample3 {
	
	//线程屏障数量,线程到达一定数量后,优先执行的方法
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> {
		log.info("子线程准备就绪,父线程准备执行计算..");
	});
	
	public static void main(String[] args) throws Exception {
		//创建线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// 向线程池中放入10个请求,间隔1S
		for (int i = 0; i < 10; i++) {
			final int threadNum = i;
			Thread.sleep(1000);
			executorService.execute(() -> {
				try {
					race(threadNum);
				} catch (Exception e) {
					log.error("异常:{}",e);
				}
			});
		}
		//关闭线程池
		executorService.shutdown();
	}
	
	//多个线程间计算
	private static void race(int threadNum) throws Exception{
		//线程执行睡眠,模拟计算过程
		log.info("{}线程计算准备." , threadNum);
		//计算结束,计数器等待当前线程,计数器值加一,等到5后,通知被等待线程继续执行
		cyclicBarrier.await();
		//线程等待结束
		log.info("{}线程等待结束..",threadNum);
	}
}
