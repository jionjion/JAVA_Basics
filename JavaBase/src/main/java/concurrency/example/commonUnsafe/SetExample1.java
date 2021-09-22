package concurrency.example.commonUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *	Set类型的线程安全性
 *	HaseSet类线程不安全
 */
@Slf4j
public class SetExample1 {

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
			int j = i;
			//执行函数,这里采用匿名函数写法
			executorService.execute(() -> {
				try {
					//是否允许执行
					semaphore.acquire();
					update(j);
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
			log.info("使用HashSet后,长度为:{}",set.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 定义业务方法
	// 全局使用的类
	public static Set<Integer> set = new HashSet<Integer>();
	public static void update(int i) {
		set.add(i);
	}

}
