package com.model.observer.observerByJDK;

import org.junit.Test;

/**
 * 	测试JDK提供的观察者模式*/

public class WeatherTest {

	/**	测试类,完成目标请求*/
	@Test
	public void client() {
		
		//1.创建天气作为被观察者
		WeatherConcreateSubject weatherConcreteSubject = new WeatherConcreateSubject();
		
		//2.创建观察者
		WeatherConcreateObserver observerGirl = new WeatherConcreateObserver();
		observerGirl.setObserverName("女票");
		WeatherConcreateObserver observerMum = new WeatherConcreateObserver();
		observerMum.setObserverName("母上大人");
		
		//3.注册观察者
		weatherConcreteSubject.addObserver(observerGirl);
		weatherConcreteSubject.addObserver(observerMum);
		
		//4.通知更新
		weatherConcreteSubject.setContent("明天天气,晴朗");
	}
}
