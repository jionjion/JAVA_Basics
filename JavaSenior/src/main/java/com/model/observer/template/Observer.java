package com.model.observer.template;
/**	
 *	观察者接口,定义了一个更新的接口给那些在目标改变时被通知的对象
 */
public interface Observer {

	void update(Subject subject);	

}
