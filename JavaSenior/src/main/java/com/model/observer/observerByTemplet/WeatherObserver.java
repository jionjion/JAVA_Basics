package com.model.observer.observerByTemplet;

/**	
 *	观察者接口,定义了一个更新的接口给那些在目标改变时被通知的对象
 */
public interface WeatherObserver {

	/**拉模型*/
	void update(WeatherSubject weatherSubject);

	/**推模型*/
	void update(String weatherContent);	

}
