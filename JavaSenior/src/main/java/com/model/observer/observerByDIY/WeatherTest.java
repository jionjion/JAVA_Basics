package com.model.observer.observerByDIY;

import org.junit.Test;

/**	对区别观察者模式测试*/
public class WeatherTest {

	/**	测试类,完成目标请求*/
	@Test
	public void client() {
		
		//1.创建天气作为被观察者
		WeatherConcreateSubject weatherConcreteSubject = new WeatherConcreateSubject();
		
		//2.创建观察者
		WeatherConcreateObserver observerGirl = new WeatherConcreateObserver();
		observerGirl.setObserverName("女票");
		observerGirl.setRemindThing("下雨了,淘宝买买买....");
		WeatherConcreateObserver observerMum = new WeatherConcreateObserver();
		observerMum.setObserverName("母上大人");
		observerMum.setRemindThing("在家打扫屋子....");

		//3.注册观察者
		weatherConcreteSubject.attach(observerGirl);
		weatherConcreteSubject.attach(observerMum);
		
		//4.通知更新
		weatherConcreteSubject.setWeatherContent("雪");	//晴,雨,雪
	}
}
