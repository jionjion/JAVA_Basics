package timedTask.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
/**
 *	定时任务模型
 *	Job类
 */
public class HelloJob implements Job {

	/**
	 * 	编写任务的执行逻辑
	 * 	并打印执行的时间
	 * 	@param JobExecutionContext 定时过程的上下文容器.可以通过其访问到Quartz运行时候的具体细节
	 * 	@exception JobExecutionException 运行失败后的抛出异常
	 */
	@SuppressWarnings("unused")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//执行时间
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//执行打印任务
		System.out.println( now + ":任务执行了...." );
		//获取任务信息
		JobKey jobKey = context.getJobDetail().getKey();
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		System.out.println("任务名:"+jobKey.getName() + "任务组:"+jobKey.getGroup() + "参数信息:"+jobDataMap.getString("message"));
		//获取触发器信息
		TriggerKey triggerKey = context.getTrigger().getKey();
		JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
		System.out.println("调度名"+triggerKey.getName() + "调度组"+triggerKey.getGroup() + "参数信息:"+ getMessage());			//使用get方法,完成参数的绑定
	}

	
	/*
	 * 	通过get/set方式获得传入参数 
	 */
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
