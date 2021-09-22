package concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 	JAVA中,锁机制
 * 	使用StampedLock构建性能优异的读写分离
 * 	在执行写入之前,需要获取写锁,如果有读锁正在执行,需要等待直到读锁结束.如果持续等待,则会造成线程饥饿
 */
@Slf4j
public class LockExample5 {

	public static void main(String[] args) {
		//定义锁
		ReentrantLock reentrantLock = new ReentrantLock();
		//获得线程控制组件
		Condition condition = reentrantLock.newCondition();
		
		new Thread(()->{
			try {
				//加锁
				reentrantLock.lock();
				log.info("第一线程等待...");
				//将当前线程放入Condition组件中的等待队列中,直到接收到开始信号
				condition.await();
			} catch (InterruptedException e) {
				log.error("InterruptedException {}",e);
			}
			
			log.info("第一得到信号...");
			reentrantLock.unlock();
		}).start();
		
		new Thread(()->{
			try {
				reentrantLock.lock();
				log.info("第二线程启动...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				log.error("InterruptedException {}",e);
			}
			//发送信号,唤醒Condition组件中的等待队列中,等待发出开始信号
			condition.signalAll();
			log.info("第二发送信号..");
			//解锁,将Condition组件中的队列进行执行
			reentrantLock.unlock();
		}).start();
		
	}
}
