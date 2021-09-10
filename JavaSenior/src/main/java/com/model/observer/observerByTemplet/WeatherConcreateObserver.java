package com.model.observer.observerByTemplet;

/**
 *	观察者的具体实现
 *	具体的观察者对象	
 */
public class WeatherConcreateObserver implements WeatherObserver{

	/*进行消息提示*/
	private String observerName;				//提醒对象的名称
	
	private String weatherContent;				//天气状态
	
	private String remindThing;					//提醒内容
	
	/**
	 * 	将目标类的状态同步到观察者的状态中
	 * 	使用拉模型,将目标出入观察者中
	 */
	@Override
	public void update(WeatherSubject subject) {
		this.weatherContent = ((WeatherConcreteSubject) subject).getWeatherContent();
		
		System.out.println(observerName + "收到了," + weatherContent + "提醒的" + remindThing);
	}

	/**
	 * 	推模型,将信息推送给观察者
	 */
	@Override
	public void update(String weatherContent) {
		this.weatherContent = weatherContent ;
		System.out.println(observerName + "收到了," + weatherContent + "提醒的" + remindThing);
	}
	
	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}

	
}
