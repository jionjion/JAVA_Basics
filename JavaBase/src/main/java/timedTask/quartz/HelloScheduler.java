package timedTask.quartz;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *	任务调度类
 *	JobDetail类
 *		为Job提供了很多属性设置,以及JobDataMap成员变量,用来储存Job的实例状态信息,通过其添加具体的Job实例
 *			name:名字
 *			group:组,参数为空时表示默认组
 *			jobClass:job的具体实现类
 *			jobDataMap:传参
 *			
 *
 *	Trigger类
 *		设置执行时间,执行触发Job,作为触发器调度
 *		通过CronTriggerImpl和SimpleTriggerImpl等实现
 *		JobKey表示job实例的标识,触发器被触发时,指定job将会执行
 *		StartTime:表示触发器的首次触发的时间.Until时间类
 *		EndTime:表示触发器最后一次触发的时间.Until时间类
 *	
 *	SimpleTriggerImpl实现类
 *		基于时间的时间触发器
 *		在指定时间段内执行 一次作业任务
 *		在指定时间间隔内重复执行多次执行任务
 *		重复次数可以是-1(无限次),0(不执行),或者正整数
 *		重复执行间隔必须为0或者长整型
 *
 *	CronTriggerImpl实现类
 *		基于日历的时间触发器
 *		使用Cron表达式:
 *			[秒] [分] [时] [日] [月] [周] [年]		
 *
 *	Scheduler类
 *		
 *
 */
public class HelloScheduler {

	public static void main(String[] args) throws Exception{
		//创建一个JobDetail实现,该实例与Job实现绑定.使用建造者模式
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)									//传入具体类类类型,通过反射描述创建实例
							.withIdentity("job_01","job_group_01")								//为任务分配任务名和任务组
							.usingJobData("message", "任务创建..")
								.build();
		System.out.println("任务明细的描述"+jobDetail.getDescription());
		System.out.println("任务明细的名字"+jobDetail.getKey().getName());
		System.out.println("任务明细的分组"+jobDetail.getKey().getGroup());
		System.out.println("任务明细的实现类"+jobDetail.getJobClass().getName());
		
		//日期时间,距离现5s后
		Date startTime = new Date();
		startTime.setTime(startTime.getTime()+5000);
		//日期时间,距离现25s后
		Date endTime = new Date();
		endTime.setTime(endTime.getTime()+25000);
		
		
		//创建一个Trigger实例,定义重复周期时间
		Trigger trigger = TriggerBuilder.newTrigger()											//创建计划实例
							.withIdentity("trigger_01", "trigger_group_01")						//分配周期名称和周期组
							.usingJobData("message","任务准备立刻开始..")
//								.startNow()														//立刻执行
								.startAt(startTime)												//开始时间 
								.endAt(endTime)													//结束时间
									.withSchedule(SimpleScheduleBuilder.simpleSchedule()		//SimpleSchedule模式进行简单间隔定义
											.withIntervalInSeconds(2)							//每隔两秒执行一次
												.repeatForever())								//重复执行
													.build();

		//创建Scheduler实例
		SchedulerFactory factory = new StdSchedulerFactory();									//工厂 模式,创建实例
		Scheduler scheduler = factory.getScheduler();											//创建实例
		scheduler.scheduleJob(jobDetail,trigger);												//绑定任务和定时周期
		scheduler.start();																		//开始执行
	}
}
