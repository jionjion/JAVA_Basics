package concurrency.example.commonUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *	String类型的线程安全性
 *	StringBuilder类		线程不安全
 *	StringBuffer类		线程安全
 */
@Slf4j
public class StringExample1 {

	//请求次数
	public static int clientTotal = 5000;
	
	//线程
	public static int threadTotal = 20;
	

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
					update();
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
			log.info("StringBuilder执行后长度:{}" , stringBuilder.toString().length());
			log.info("stringBuffer执行后长度:{}" , stringBuffer.toString().length());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 定义业务方法
	// 线程不安全的类
	public static StringBuilder stringBuilder = new StringBuilder();
	public static StringBuffer stringBuffer = new StringBuffer();
	public static void update() {
		stringBuilder.append("1");
		stringBuffer.append("1");
	}

}
