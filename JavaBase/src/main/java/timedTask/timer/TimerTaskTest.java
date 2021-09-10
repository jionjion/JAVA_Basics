package timedTask.timer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;
/**自定义定时任务*/
public class TimerTaskTest extends TimerTask{

	/**封装属性*/
	private String name;
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**执行计数*/
	public int count = 0;
	/**自定义打印任务*/
	public void printTask() {
		if (name != null) {
			if (count <= 3) {
				System.out.println("任务执行.....姓名:"+name);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
				System.out.println("下次执行时间:"
							+ simpleDateFormat.format(scheduledExecutionTime()));
				count ++;
			}else{
				cancel();		//取消执行
				System.out.println("任务取消");
				scheduledExecutionTime();
			}
		}
	}

	@Override
	/**覆盖执行方法*/
	public void run() {
		//进行任务调度
		printTask();
	}
}
