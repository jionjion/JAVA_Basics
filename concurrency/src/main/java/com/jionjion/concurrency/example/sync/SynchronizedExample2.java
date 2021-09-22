package com.jionjion.concurrency.example.sync;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * 	使用Synchronized关键字实现锁
 */
@Slf4j
public class SynchronizedExample2 {

	/**线程不安全的方法*/
	public void test(int threadNum) {
		for (int i=0 ; i<10 ; i++) {
			System.out.println("线程" + threadNum + "-当前值:" + i);
		}
	}		
	
	/**
	 * 	使用Synchronized修饰类
	 * 	作用域为全部对象
	 */
	public static void test1(int threadNum) {
		
		synchronized (SynchronizedExample2.class) {
			for (int i=0 ; i<10 ; i++) {
				System.out.println("线程" + threadNum + "-当前值:" + i);
			}
		}
	}
	
	/**
	 * 	使用Synchronized修饰方法
	 * 	作用域为所有对象
	 */
	public static synchronized void test2(int threadNum) {
		for (int i=0 ; i<10 ; i++) {
			System.out.println("线程" + threadNum + "-当前值:" + i);
		}
	}	
	
	
	/** 测试 
	 * 		所有对象的改方法线程安全,同一时刻只能有一个对象该方法执行,因此不同线程顺序打印0-9
	 * */
	public static void main(String[] args) {
		//多个线程池分别调用方法
		for (int i = 0; i < 2; i++) {
			int j = i;
			SynchronizedExample2 example1 = new SynchronizedExample2();
			ExecutorService executorService = Executors.newCachedThreadPool();
				//执行方法,执行匿名函数
				executorService.execute(()->{
					example1.test2(j);
				});
			}
		}
}
