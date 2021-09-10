package com.model.observer.observerByDIY;

/**	子类实现,具体的天气类*/
public class WeatherConcreateSubject extends WeatherSubject {

	/**存储天气情况,根据天气情况区别对待观察者*/
	private String weatherContent;			//晴,雨,雪
	
	
	/**通知观察者*/
	@Override
	protected void notifyObservers() {
		/*	循环遍历父类的观察者们
		 *	规则:女票通知雨天
		 *		母上通知雨天和雪天 	
		 */
		for (Observer observer : observers) {
			//晴天,都不通知
			
			//雨天,通知女票和母上
			if ("雨".equals(this.getWeatherContent())) {
				if ("女票".equals(observer.getObserverName())) {
					observer.update(this);			//通知
				}
				if ("母上大人".equals(observer.getObserverName())) {
					observer.update(this);			//通知
				}
			}
			
			//雪天,通知母上
			if ("雪".equals(this.getWeatherContent())) {
				if ("母上大人".equals(observer.getObserverName())) {
					observer.update(this);			//通知
				}
			}
		}
	}
	
	
	
	public String getWeatherContent() {
		return weatherContent;
	}

	/**设置天气状态,并调用通知方法,通知观察者*/
	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}



}
