package timedTask.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 * 	Scheduler调度者的测试类
 * 	
 */	
public class SchedulerTest {

	/**	调度者的测试类*/
	@Test
	public void testOne() {
		try {
			//创建一个JobDetail实现,该实例与Job实现绑定.使用建造者模式
			JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)									//传入具体类类类型,通过反射描述创建实例
								.withIdentity("job_01","job_group_01")								//为任务分配任务名和任务组
								.usingJobData("message", "任务创建..")
									.build();
			
			
			//创建一个Trigger实例,定义重复周期时间
			CronTriggerImpl trigger = (CronTriggerImpl) TriggerBuilder.newTrigger()						//创建计划实例
								.withIdentity("trigger_01", "trigger_group_01")						//分配周期名称和周期组
								.usingJobData("message","任务准备立刻开始..")
									.withSchedule(
											CronScheduleBuilder.cronSchedule("0 * * * * ? *"))		//每分钟执行一次		
													.build();

			//创建Scheduler实例
			SchedulerFactory factory = new StdSchedulerFactory();									//工厂 模式,创建实例
			Scheduler scheduler = factory.getScheduler();											//创建实例
			Date nextTime = scheduler.scheduleJob(jobDetail,trigger);								//绑定任务和定时周期,返回最近一次执行时间
			scheduler.start();				//开始		
			System.out.println("下一次执行时间:" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(nextTime));
			
			//线程休眠1分钟后
			Thread.sleep(60000);
			//挂起
			scheduler.standby();
			//重启开启
			scheduler.start();
			//关闭,等待最后一个执行完关闭后
			scheduler.shutdown(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SchedulerTest().testOne();
	}
}
