package com.model.observer.observerByJDK;

import java.util.Observable;
import java.util.Observer;

/**
 * 	具体的观察者实现对象*/
public class WeatherConcreateObserver implements Observer {

	/**观察者的名称对象*/
	private String observerName;
	
	/**
	 * 	@param Observable:拉模型,传入的观察对象,可以通过观察对象获得更新内容
	 * 	@param Object:推模型,传入的参数,代表了具体的推送内容
	 */
	@Override
	public void update(Observable observable, Object object) {
		//推的方式
		System.out.println(observerName+"收到消息,目标推送消息是:"+object);
		//拉的方式
		System.out.println(observerName+"拉取消息是:"
									+((WeatherConcreateSubject)observable).getContent());
	}

	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
	

}
