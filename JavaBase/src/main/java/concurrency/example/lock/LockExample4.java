package concurrency.example.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;


/**
 * 	JAVA中,锁机制
 * 	使用StampedLock构建性能优异的读写分离
 * 	在执行写入之前,需要获取写锁,如果有读锁正在执行,需要等待直到读锁结束.如果持续等待,则会造成线程饥饿
 */
public class LockExample4 {

	//请求次数
	public static int clientTotal = 5000;
	
	//线程
	public static int threadTotal = 20;

	//线程锁
	private final static StampedLock lock = new StampedLock();
	
	public static void main(String[] args) {
		
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
	
	//定义业务方法
	public static int sum = 0;
	//将锁作用在实现方法中 
	public static void add() {
		//进行读锁和写锁相分离,并返回一个时间戳
		long stamp = lock.writeLock();
		try {
			sum ++;
		} finally {
			//使用时间戳,解锁当前线程
			lock.unlock(stamp);
		}
	}
}
