package armVisible;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**	volatile修饰的变量,实现内存可见性,但是不能保证原子性
 * 	原子性可以通过在多线程执行的方法中增加synchronized修饰
 * 	或者使用Lock类结合try_finally实现语句块的原子性*/
public class VolatileDemo {

	//声明一个变量
	private volatile int number = 0;
	
	//提供get方法,获取该变量
	public int getNumber() {
		return this.number;
	}
	//原子锁
	private Lock lock = new ReentrantLock();
	
	//对改变变量进行自增操作
	public void inCreate() {				//增加synchronized关键字保证原子性
							//自加分三步:读取->自加->写入,不能保证原子性,在多线程多次写入后,发生抢占数据,值会改变
		//增加锁
		lock.lock();
		try {
			this.number ++;		//执行自增操作
		} finally {
			lock.unlock();		//解锁
		}
	}
	
	
	/**主线程,使用不同的分线程,完成自加操作*/
	public static void main(String[] args) {
		
		final VolatileDemo demo = new VolatileDemo();
		for (int i = 0; i < 500	; i++) {	//执行500次多线程
			//传入匿名内部类,创建实例
			new Thread(new Runnable() {
				@Override
				public void run() {
					demo.inCreate();
				}
			}).start();					//执行线程
		}
		
		/**如果当前仍有子线程在运行,则让主线让出CUP,等待所有子线程运行完后,执行主线程*/
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		System.out.println("当前变量值为:"+demo.getNumber());
	}
}
