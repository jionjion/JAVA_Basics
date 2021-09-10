package com.model.strategy;
/**
 *	鸭子模型
 */
public abstract class Duck {

	
	/**
	 * 	模仿鸭子的发出叫声
	 * 	通用行为,由超类实现
	 */
	public void quack() {
		System.out.println("模仿鸭子的叫声.....嘎嘎");
	}
	
	
	/**
	 * 显示不同的鸭子外观,由子类实现
	 */
	public abstract void display();
	
	
	/**
	 *	使用组合方式,私有引用接口,调用接口的子类而获得接口的方法 	
	 */
	//1.首先私有接口策略
	private FlyStrategy flyStrategy;
	/**将实现接口的子类注入*/
	public void setFly(FlyStrategy flyStrategy) {	//2.将接口策略通过setFly()进行注入.
		this.flyStrategy = flyStrategy;
	}
	public void fly() {
		flyStrategy.performFly();			//3.调用接口的方法,实现组合
	}
	
	
}
