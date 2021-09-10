package com.model.observer.observerByDIY;

import java.util.ArrayList;
import java.util.List;

/**
 * 	区别观察者
 * 	定义一个抽象的被观察者,交由子类完成实现
 * 	*/
public abstract class WeatherSubject {

	//保存观察者对象
	public List<Observer> observers = new ArrayList<Observer>();
	
	//增加观察者对象
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	//删除观察者
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**父类定义抽象的方法,交由子类去实现*/
	protected abstract void notifyObservers();
}
