---
title: JAVA中timer定时任务调度
tags: JDK8, Eclipse, timer
---

[TOC]

---

## 简介
JDK提供的定时调度实现,可以很方便的对指定次数,指定周期,指定时间的任务进行执行.
但是由于为单线程执行,并发难以应付;同时,如果一个定时调度抛出异常后,将会使整个调度系统停止.

## 类文件

- `TimerTaskTest`自定义要被调度的任务
- `TimerTest`调度任务执行类

## 类文件描述
### `TimerTaskTest`类
通过继承`TimerTask`类,创建自定义执行任务方法`printTask()`,并在`run()`方法中执行,1实现只打印三次线程执行者的任务.

- 继承自`TimerTask`类,创建线程属性
- 编写自定义方法,执行三次后`cancel()`取消调度
- 在`run()`方法中调用自定义方法

``` java
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
```

### `TimerTest`类
定时调度任务类,可以根据时间点,间隔时间,自定义完成调度任务.

| 方法                                   | 参数                           | 说明                                              |
| -------------------------------------- | ------------------------------ | ------------------------------------------------- |
| schedule(task,time)                    | 执行任务,执行时间              | 在时间等于或者超过time的时候执行一次任务          |
| schedule(task,time,period)             | 执行任务,执行时间,间隔时间     | 在指定时间执行一次任务,随后间隔多少毫秒继续执行   |
| scheduleAtFixedRate(task,time,period)  | 执行任务,执行时间,间隔时间     | 在指定时间执行一次任务,随后间隔多少毫秒继续执行   |
| schedule(task,delay)                   | 执行任务,执行前的停顿          | 调用后延时一段时间后执行一次                      |
| schedule(task,delay,period)            | 执行任务,执行前的停顿,间隔时间 | 调用后延时一段时间后执行,随后间隔多少毫秒继续执行 |
| scheduleAtFixedRate(task,delay,period) | 执行任务,执行前的停顿,间隔时间 | 调用后延时一段时间后执行,随后间隔多少毫秒继续执行 |
| cancel()                               |                                | 取消执行方法                                      |
| scheduledExecutionTime()               |                                | 返回最近任务执行的时间,返回值为long型,需要转换    |
| purge()                                |                                |                                                   |


#### **基本用法**
- 创建`Timer`调度实例
- 创建任务实例,并设置名称
- 调度执行`schedule()`传入参数

``` java
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
```

#### **`schedule()`指定时间进行调度**

``` java
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
```

#### **`schedule()`指定时间和间隔进行调度**

``` java
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
```

#### **`schedule()`指定时间和延时时间进行调度**

``` java
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
```

#### **`schedule()`指定时间和延时时间以及间隔进行调度**

``` java
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
```


#### **`scheduleAtFixedRate()`指定时间和间隔进行调度**

``` java
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
```

#### **`scheduleAtFixedRate()`指定时间和延时时间以及间隔进行调度**

``` java
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
```


#### **测试:当执行时间早于当前或者大于间隔时间时,两者的区别**

- 任务执行时间为当前时间之前.
`schedule`:实际执行时间为当前时间,并为了赶上进度而在后面多次执行
`scheduleAtFixedRate`:实际执行为当前时间,并为了赶上进度而立即多次补上执行.

- 任务执行时间超过间隔时间
`schedule`:下一次的执行时间从本次实际的开始进行,因此任务不断调整实际执行时间
`scheduleAtFixedRate`:继续按照正常时间进行,有并发性

``` java
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
```


