package threadAndRunnable;

/**
 *	买票类,通过继承实现多线程
 *	5张票,3个窗口卖票
 */
public class TicketsByThread extends Thread {

	private static int ticketsNumber = 5;			//票的总数
	
	private String name;							//线程的名字

	public TicketsByThread(String name) {				//通过构造器为线程赋值名称
		this.name = name;
	}

	//买票方法,通过synchronized实现变量ticketsNumber的同步
	private synchronized void sell() {
		while(ticketsNumber>0) {
			ticketsNumber -- ;
			System.out.println(Thread.currentThread().getName()+"卖出了一张票,还剩:"+ticketsNumber);
		}
	} 
	
	@Override
	public void run() {
		sell();
	}
	
	
	/**	创建三个线程,模拟三个线程买票*/
	public static void main(String[] args) {
		
		//创建多线程
		TicketsByThread thread_1 = new TicketsByThread("窗口一");
		TicketsByThread thread_2 = new TicketsByThread("窗口二");
		TicketsByThread thread_3 = new TicketsByThread("窗口三");
		
		//启动多线程
		thread_1.start();
		thread_2.start();
		thread_3.start();
	}
	
	
}
