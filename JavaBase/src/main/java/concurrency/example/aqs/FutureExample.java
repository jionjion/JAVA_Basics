package concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample {

	//调用回调函数
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程池,使用线程池调用回调方法
		ExecutorService executorService = Executors.newCachedThreadPool();
		//使用Future获得另外线程的计算结果
		Future<Object> future = executorService.submit(new CallableImp());
		//等待,回调执行完成后,方能获取值
		Thread.sleep(500);
		Object result = future.get();
		log.info("获得线程计算结果:{}",result);
		
		executorService.shutdown();
	}
	
	//定义一个实现了Callable接口的内部类
	static class CallableImp implements Callable<Object>{

		//实现其定义方法,返回值为当前泛型中定义的String类型
		@Override
		public String call() throws Exception {
			log.info("回调正在执行...");
			Thread.sleep(5000);
			return "OK";
		}
	} 
}
