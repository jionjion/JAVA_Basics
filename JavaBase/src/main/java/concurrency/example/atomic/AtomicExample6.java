package concurrency.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 	AtomicBoolean示例
 * 	可以使某段代码在并发访问时,最多只能执行一次
 */
public class AtomicExample6 {
	
	
	
	//请求次数
	public static int clientTotal = 5000;
	
	//线程
	public static int threadTotal = 20;
	
	//定义,是否发生过,一个线程只允许执行一次
	private static AtomicBoolean isHappened = new AtomicBoolean(false);
	
	//业务方法,使用工具包修饰
	public static void test() {
		//某个线程执行过后,则将状态改变
		if(isHappened.compareAndSet(false, true)) {
			System.out.println("业务方法只期望执行一次...");
		}
	}
	
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
					test();
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
			System.out.println("业务方法是否执行:" + isHappened.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
