package threadAndRunnable;

public class TicketsByRunnable implements Runnable {

	private static int ticketsNumber = 5;			//票的总数
	
	
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

	public static void main(String[] args) {
		
		//创建实现线程接口的方法
		TicketsByRunnable thread_runnable = new TicketsByRunnable();
		Thread thread_01 = new Thread(thread_runnable, "窗口一");
		Thread thread_02 = new Thread(thread_runnable, "窗口二");
		Thread thread_03 = new Thread(thread_runnable, "窗口三");
		
		//启动线程实例
		thread_01.start();
		thread_02.start();
		thread_03.start();
	}
	
}
