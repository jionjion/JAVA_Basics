package timedTask.quartz;

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
 * 	使用 CronTrigger完成测试类
 * 	
 * 	使用Cron表达式:
 *		[秒] [分] [时] [日] [月] [周] [年]		
 *		,表示或		-表示至		*表示每		/表示每		?表示不关心		#表示第	
 *	例如
 * 		* 	* 	* 	* 	* 	? 	*					每秒都触发一次
 * 		0 	15	10	?	*	?	*					每天10点15分触发
 * 		0	0/5	14	*	*	?	*					每天下午的2点到2点59分,每隔5分钟触发一次.		0/5:从0分开始,每五分钟执行一次
 * 		0	15	10	?	*	2-6	*					每周一到周五10点15分触发
 * 		0	15	10	?	*	6#3	*					每月的第三周的星期五触发
 * 		0	15	10	?	*	6L	2016-2017			2016年到2017年每月最后一周的星期五10点15分触发	6L:表示最后一周的周五	
 */	
public class CronTriggerTest {

	/**	通过日历进行调用*/
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
											CronScheduleBuilder.cronSchedule("* * * * * ? *"))		
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
		new CronTriggerTest().testOne();
	}
}
