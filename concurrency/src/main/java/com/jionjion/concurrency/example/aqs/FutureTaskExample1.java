package com.jionjion.concurrency.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


import lombok.extern.slf4j.Slf4j;

/**
 *	使用FutureTask完成对异步线程的调用
 */
@Slf4j
public class FutureTaskExample1 {

	 //调用回调函数
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//使用FutureTask类,并传入实现Callable的回调函数
		FutureTask<String> futureTask = new FutureTask<String>(
			new Callable<String>() {
				@Override
				public String call() throws Exception {
					log.info("回调正在执行...");
					Thread.sleep(2000);
					return "OK";
				}
		});
		
		//使用线程调度启用
		log.info("线程启动成功");
		new Thread(futureTask).start();
		//经过一段时间,回调计算完成,等待时间不必比执行时间短
		Thread.sleep(5000);
		//获得处理结果
		log.info("获得线程计算结果:{}",futureTask.get());
	}
}
