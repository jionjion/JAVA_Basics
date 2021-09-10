package armVisible;
/**	线程锁的案例
 * 	synchronized关键字保证其内部方法执行时不会因为多线程而分次被干扰*/
public class SynchronizedDemo {

	/**共享变量*/
	private boolean ready = false;	//是否可读标志
	private int result = 0;
	private int number = 1;
	
	/**写操作,为共享变量写入最新值*/
	public synchronized void write() {
		ready = true;				//①
		number = 2;					//②
	}
	
	/**读操作,为共享变量读取最新值*/
	public synchronized void read() {
		if (ready) {				//③
			result = number * 3;	//④	
		}
		System.out.println("result的值为:"+result);
	}
	
	/**内部类*/
	private class ReadWriteThread extends Thread{
		//根据构造方法中传入的flag参数,确定线程执行读操作或者写操作
		private boolean flag;
		public ReadWriteThread (boolean flag) {
			this.flag = flag;
		}
		
		@Override
		public void run() {
			if (flag) {
				write();
			}else{
				read();
			}
		}
	}
	
	
	/**	启动线程
	 * 	结果为6: ①->②->③->④
	 * 	结果为0:
	 * */
	public static void main(String[] args) {
		SynchronizedDemo demo  = new SynchronizedDemo();
		//启动线程,执行写操作
		demo.new ReadWriteThread(true).start();
		//启动线程,执行写操作
		demo.new ReadWriteThread(false).start();
	}
	
}
