package javaThread;
/**舞台类,继承实现多线程*/
public class Stage extends Thread {

	@Override
	public void run() {
		
		ArmyRunnable iarmOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable iarmOfRevolt = new ArmyRunnable();
		//使用Runnable接口创建线程
		Thread armOfSuiDynasty = new Thread(iarmOfSuiDynasty, "隋朝军队");
		Thread armOfRevolt = new Thread(iarmOfRevolt, "农民军队");
		
		//启动线程
		armOfSuiDynasty.start();
		armOfRevolt.start();
		
		//休眠,控制输出时间
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("线程休眠出现异常");
		}

		//军队线程停止
//		armOfSuiDynasty.stop();		//强行停止,不建议使用
//		armOfRevolt.stop();
		iarmOfSuiDynasty.keepRunning = false;
		iarmOfRevolt.keepRunning = false;
		
		//其他加入
		Thread peopel = new KeyPerson();
		peopel.setName("程咬金");
		System.out.println("关键人物登场....");
		peopel.start();
		try {
			peopel.join();		//线程启动,其他线程等待该线程结束
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("线程启动出现异常");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new Stage().start();
	}
}
