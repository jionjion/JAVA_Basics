package concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 	Semaphore的测试类
 * 	这里测试获取释放多个许可,进行并发控制
 *	1.定义Semaphore类实例
 *	2.在需要采用并发数量控制的方法前后增加acquire()和release()
 */
@Slf4j
public class SemaphoreExample3 {

	//计数数量
	private static int threadCount = 200;
	
	
	public static void main(String[] args) throws Exception {
		
		//线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		//构建计数器,计数数量为200
		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		//并发数量控制
		final Semaphore semaphore = new Semaphore(10); 
		
		//循环启动线程池
		for(int i=0 ; i < threadCount ; i++) {
			//final修饰的变量可以传入线程中
			final int threadNum = i;
			executorService.execute(() -> {
				try {
					//尝试获取5个许可,如果获取则执行线程方法,尝试获取100毫秒
					if(semaphore.tryAcquire(5,100, TimeUnit.MILLISECONDS)) {
						//执行测试方法
						test(threadNum);
						//释放线程许可
						semaphore.release(5);
					}
				} catch (Exception e) {
					log.error("错误:{}" ,e);
				} finally {
					//执行结束,当前计数器-1
					countDownLatch.countDown();
				}
			});
		}
		
		//等待,直到计数器中计数归零
		countDownLatch.await();
		log.info("线程结束");
		//线程池关闭
		executorService.shutdown();
	}
	
	private static void test(int threadNum) throws Exception{
 		log.info("线程{}",threadNum);
 		Thread.sleep(100);
	}
}
