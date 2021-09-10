package timedTask.quartz;

import java.util.Date;

import org.junit.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 	使用 SimpleTrigger完成测试类
 * 	
 */
public class SimpleTriggerTest {

	/**	指定时间后,执行一次或者多次*/
	@Test
	public void testOne() {
		try {
			//创建一个JobDetail实现,该实例与Job实现绑定.使用建造者模式
			JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)									//传入具体类类类型,通过反射描述创建实例
								.withIdentity("job_01","job_group_01")								//为任务分配任务名和任务组
								.usingJobData("message", "任务创建..")
									.build();
			
			//日期时间,距离现5s后
			Date startTime = new Date();
			startTime.setTime(startTime.getTime()+5000);
			//日期时间,距离现25s后
			Date endTime = new Date();
			endTime.setTime(endTime.getTime()+25000);
			
			//创建一个Trigger实例,定义重复周期时间
			SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()						//创建计划实例
								.withIdentity("trigger_01", "trigger_group_01")						//分配周期名称和周期组
								.usingJobData("message","任务准备立刻开始..")
								.startAt(startTime)
								.endAt(endTime)
									.withSchedule(
											SimpleScheduleBuilder.simpleSchedule()					//SimpleSchedule模式进行简单间隔定义
											.withIntervalInSeconds(2)								//每隔两秒执行一次
												.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))//withRepeatCount定义重复的次数
													.build();

			//创建Scheduler实例
			SchedulerFactory factory = new StdSchedulerFactory();									//工厂 模式,创建实例
			Scheduler scheduler = factory.getScheduler();											//创建实例
			scheduler.scheduleJob(jobDetail,trigger);												//绑定任务和定时周期
			scheduler.start();		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SimpleTriggerTest().testOne();
	}
}
