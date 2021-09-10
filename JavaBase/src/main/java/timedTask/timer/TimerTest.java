package timedTask.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


/**对自定义时间任务进行调度*/
public class TimerTest {
	
	/**基本用法*/
	public void testOne() {
		//1.创建调度实例
		Timer timer = new Timer();
		//2.创建任务实例
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//3.执行定时调度:当前时间进行调度,随后没两秒进行一次.
		//执行任务的run方法,当前时间后多少毫秒,随后间隔多少毫秒
		timer.schedule(task, 2000L, 1000L);	
	}
	

	/**设定时间,随后进行调度*/
	public void testTwo() {
		Timer timer = new Timer();
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//为当前时间加5秒
		calendar.add(Calendar.SECOND, 5);
		//执行任务的run方法,当前时间后多少毫秒,随后线程阻塞
		timer.schedule(task, calendar.getTime());
	}
	
	/**设定时间,随后进行调度,每隔毫秒数进行*/
	public void testThree() {
		Timer timer = new Timer();
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//为当前时间加5秒
		calendar.add(Calendar.SECOND, 5);
		//执行任务的run方法,当前时间后多少毫秒,随后间隔2000毫秒,进行执行
		timer.schedule(task, calendar.getTime(),2000L);
	}
	
	/**设定时间,随后进行延时调度*/
	public void testFour() {
		Timer timer = new Timer();
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//执行任务的run方法,延时2000毫秒,进行执行
		timer.schedule(task,2000L);
	}
	
	/**设定时间,随后进行延时调度,每隔毫秒数进行*/
	public void testFive() {
		Timer timer = new Timer();
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//执行任务的run方法,延时2000毫秒,进行执行,随后每5s执行
		timer.schedule(task,2000L,5000L);
	}
	
	/**设定时间,随后指定时间进行调度,每隔毫秒数进行*/
	public void testSix() {
		Timer timer = new Timer();
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//为当前时间加5秒
		calendar.add(Calendar.SECOND, 5);
		//执行任务的run方法,执行时间为当前时间后加5s,随后每2s执行
		timer.scheduleAtFixedRate(task, calendar.getTime(),2000L);
	}
	
	/**设定时间,随后进行调度,每隔毫秒数进行*/
	public void testSeven() {
		Timer timer = new Timer();
		TimerTaskTest task = new TimerTaskTest();
		task.setName("JION.JION");
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//为当前时间加5秒
		calendar.add(Calendar.SECOND, 5);
		//执行任务的run方法,延时5s后执行,随后每2s执行
		timer.scheduleAtFixedRate(task, 5000L,2000L);
	}
	
	/**任务执行时间为当前时间之前.
	 * schedule:实际执行时间为当前时间,并为了赶上进度而在后面多次执行
	 * scheduleAtFixedRate:实际执行为当前时间,并为了赶上进度而立即多次补上执行.
	 * 任务执行时间超过间隔时间
	 * schedule:下一次的执行时间从本次实际的开始进行,因此任务不断调整实际执行时间
	 * scheduleAtFixedRate:继续按照正常时间进行,有并发性*/
	public void testEight() {
		Timer timer = new Timer();
		//创建时间对象
		Calendar calendar = Calendar.getInstance();//单例模式
		//创建时间格式对象 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
		//打印当前时间
		System.out.println("执行时间"+simpleDateFormat.format(calendar.getTime()));
		//为当前时间5秒之前
		calendar.add(Calendar.SECOND, -5);
		//执行任务的run方法,当前时间后多少毫秒,随后间隔2000毫秒,进行执行
		timer.scheduleAtFixedRate(new TimerTask() {
//		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
				System.out.println("匿名内部类正在进行....");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.err.println("线程执行出现问题...");
				}
				System.out.println("最近执行时间"+simpleDateFormat.format(scheduledExecutionTime()));
			}
		}, calendar.getTime(),2000L);	
	}
	
	public static void main(String[] args) {
		new TimerTest().testEight();
	}
}
