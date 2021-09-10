package com.model.observer.observerByJDK;

import java.util.Observable;
/**
 * 	使用JDK提供的方式,实现观察对象
 * 	实现天气情况,并通知所有注册的观察者对象*/
public class WeatherConcreateSubject extends Observable {

	/**天气情况*/
	private String content;

	public String getContent() {
		return content;
	}

	/**变更天气状态,并通知所有观察者*/
	public void setContent(String content) {
		this.content = content;
		this.setChanged();				//JDK所特有的
		this.notifyObservers(content);			//使用推模型,实现通知
//		this.notifyObservers();					//使用拉模型,实现通知
	}
	
	
}
