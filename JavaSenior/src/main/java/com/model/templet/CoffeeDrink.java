package com.model.templet;

/**	
 * 	调用模板方法
 *	继承父类,实现父类定义的只能交由子类实现的方法
 */
public class CoffeeDrink extends RefreshDrink {

	@Override
	/**泡制饮料*/
	protected void brew() {
		System.out.println("使用沸水煮咖啡豆");
	}

	@Override
	/**加入调味料*/
	protected void addCondiments() {
		System.out.println("加入糖和牛奶");
	}

}
