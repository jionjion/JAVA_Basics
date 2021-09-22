package concurrency.example.commonUnsafe;

import java.util.Vector;

/**
 *	Vector类型的线程安全性
 *	使用Vector类	同时执线程时的安全性
 */
public class VectorExample2 {

	//共有的同步容器
	public static Vector<Integer> vector = new Vector<>();
	
	public static void main(String[] args) {
		//赋初值
		for (int i = 0; i < 10; i++) {
			vector.add(i);
		}
		
		//定义线程一,并重写方法,删除共有容器的元素
		Thread thread1 = new Thread() {
			public void run() {
				//赋初值
				for (int i = 0; i < 10; i++) {
					vector.remove(i);
				}				
			};
		};
		
		//定义线程二,重写方法,获得共有线程的元素
		Thread thread2 = new Thread() {
			public void run() {
				//赋初值
				for (int i = 0; i < 10; i++) {
					vector.get(i);
				}				
			};
		};
		
		thread1.run();
		thread2.run();
	}
}
