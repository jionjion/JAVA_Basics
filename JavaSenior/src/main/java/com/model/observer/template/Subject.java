package com.model.observer.template;
/**
 * 	目标对象,知道观察者是谁,提供给观察者相应的添加/删除接口
 */

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	/**保存注册的观察者对象*/
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**新增观察者的方法*/
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	/**删除观察者的方法*/
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**通知观察者*/
	protected void notifyObserver() {
		for(Observer observer : observers) {
			observer.update(this);
		}
	}
}
