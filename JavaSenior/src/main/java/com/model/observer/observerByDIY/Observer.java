package com.model.observer.observerByDIY;
/**
 *	观察者
 *	定义一个更新的接口,给那些目标发生改变的时候被通知的观察者调用
 */
public interface Observer {

	/**更新接口*/
	void update(WeatherSubject weatherSubject);
	
	/**设置观察者的名称*/
	void setObserverName(String observerName);
	
	/**获得观察者名字*/
	String getObserverName(); 
}
