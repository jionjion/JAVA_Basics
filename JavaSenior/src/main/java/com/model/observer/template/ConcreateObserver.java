package com.model.observer.template;

/**
 *	观察者的具体实现
 *	具体的观察者对象	
 */
public class ConcreateObserver implements Observer{

	
	/*观察者的状态*/
	private String observerState; 
	
	/**
	 * 	将目标类的状态同步到观察者的状态中
	 */
	@Override
	public void update(Subject subject) {
		this.observerState = ((ConcreteSubject) subject).getSubjectState();
	}

	
}
