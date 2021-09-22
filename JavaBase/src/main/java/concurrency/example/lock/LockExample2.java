package concurrency.example.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 	JAVA中,锁机制
 * 	使用ReentrantLock类完成加锁和解锁
 */
public class LockExample2 {


	//请求次数
	public static int clientTotal = 5000;
	
	//线程
	public static int threadTotal = 20;

	//线程锁
	private final static Lock lock = new ReentrantLock();
	
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
		lock.lock();
		try {
			sum ++;
		} finally {
			//注意,在finally语句块中一定要写上解锁,避免实际生产中线程异常导致死锁的产生
			lock.unlock();
		}
	}
}
