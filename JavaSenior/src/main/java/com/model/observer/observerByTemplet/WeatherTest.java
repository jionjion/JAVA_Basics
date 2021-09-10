package com.model.observer.observerByTemplet;

import org.junit.Test;

public class WeatherTest {

	/**	测试类,完成目标请求*/
	@Test
	public void client() {
		//1.创建目标
		WeatherConcreteSubject weatherConcreteSubject = new WeatherConcreteSubject();
		//2.创建观察者
		WeatherConcreateObserver observerGirl = new WeatherConcreateObserver();
		observerGirl.setObserverName("女票");
		observerGirl.setRemindThing("我们约会吧!");
		
		WeatherConcreateObserver observerMum = new WeatherConcreateObserver();
		observerMum.setObserverName("母上大人");
		observerMum.setRemindThing("今天去买买买...");
		
		//3.注册观察者
		weatherConcreteSubject.attach(observerGirl);
		weatherConcreteSubject.attach(observerMum);
		
		//4.目标天气发布
		weatherConcreteSubject.setWeatherContent("明天天气,晴朗");
		
	}
}
