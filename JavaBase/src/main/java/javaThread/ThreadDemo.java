package javaThread;
/**
 * 	里面有两个类,一个通过继承重写,一个通过接口实现,均重写了Run()
 * 	可以看出,里面的方法在执行时顺序是可变的,没有实现原子性.
 * 	每一个方法执行的先后顺序由电脑决定
 * */
public class ThreadDemo extends Thread{

	@Override
	public void run(){
		try {
			int count = 0;
			for(int i=0; i<20 ;i++){
				String threadName = this.getName();	//获得线程的名字,名字由set()存入
				System.out.print("线程名为:"+threadName);
				System.out.println("\t出现了"+(++count)+"次");
				Thread.sleep(100);					//线程休眠100毫秒
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("多线程调用出现异常");
		}		
	}
	
	
	public static void main(String[] args) {
		//使用多态,父类的引用由子类实现
		Thread thread1 = new ThreadDemo();
		thread1.setName("线程I");		//设置线程的名字
		thread1.start();				//开始执行线程
		
		//使用接口,传入接口的实现类,创建多线程对象
		Thread thread2 = new Thread(new ThreadDemo2(), "线程II");
		thread2.start();
		
	}
}

class ThreadDemo2 implements Runnable{

	@Override
	public void run() {
		try {
			int count = 0;
			for(int i=0; i<20 ;i++){
				String threadName = Thread.currentThread().getName();	//线程,获得当前线程,然后获得线程名字
				System.out.print("线程名为:"+threadName);
				System.out.println("\t出现了"+(++count)+"次");
				Thread.sleep(100);					//线程休眠100毫秒
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("多线程调用出现异常");
		}	
	}
}