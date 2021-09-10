package com.model.observer.observerByDIY;

public class WeatherConcreateObserver implements Observer {

	/**观察者的名称*/
	private String observerName;
	
	//天气情况的内容
	private String weatherContent;
	
	/**提醒内容,子类实现*/
	private String remindThing;
	
	/**通知发布*/
	@Override
	public void update(WeatherSubject subject) {
		//从被观察者中获取信息
	 	weatherContent = ((WeatherConcreateSubject)subject).getWeatherContent();
	 	System.out.println(observerName + "收到了" + weatherContent +"," + remindThing);
	}

	@Override
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public String getObserverName() {
		return observerName;
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
