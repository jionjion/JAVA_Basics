package javaThread;
/**模拟军队的进攻请求,通过实现接口完成调用*/
public class ArmyRunnable implements Runnable {

	//volatile保证了改值的可见性,同时作为旗标,控制线程结束
	volatile boolean keepRunning = true;	
	
	@Override
	public void run() {
		while(keepRunning){
			for (int i = 1; i < 5; i++) {
				System.out.println(
						Thread.currentThread().getName()
						+"进攻对方["+i+"]次");
				Thread.yield();		//让出CPU资源,下次抢占CPU未知
			}
		}
	}

}
