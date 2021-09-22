package com.jionjion.concurrency.example.sync;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 	原子性
 * 	使用Synchronized关键字实现锁
 */
public class SynchronizedExample1 {

	/**线程不安全的方法*/
	public void test(int threadNum) {
		for (int i=0 ; i<10 ; i++) {
			System.out.println("线程" + threadNum + "-当前值:" + i);
		}
	}		
	
	/**
	 * 	使用Synchronized修饰代码块
	 * 	作用域为调用者对象
	 */
	public void test1(int threadNum) {
		
		synchronized (this) {
			for (int i=0 ; i<10 ; i++) {
				System.out.println("线程" + threadNum + "-当前值:" + i);
			}
		}
	}
	
	/**
	 * 	使用Synchronized修饰方法
	 * 	作用域为调用者对象
	 */
	public synchronized void test2(int threadNum) {
		for (int i=0 ; i<10 ; i++) {
			System.out.println("线程" + threadNum + "-当前值:" + i);
		}
	}	
	
	
	/** 测试
	 * 		针对每一类线程安全,线程之间交替打印0-9
	 *  */
	public static void main(String[] args) {
		//多个线程池分别调用方法
		for (int i = 0; i < 2; i++) {
			int j = i;
			SynchronizedExample1 example1 = new SynchronizedExample1();
			ExecutorService executorService = Executors.newCachedThreadPool();
				//执行方法,执行匿名函数
				executorService.execute(()->{
					example1.test(j);
				});
			}
		}
}
