package com.model.templet;

/**	
 * 	调用模板方法
 *	继承父类,实现父类定义的只能交由子类实现的方法
 */
public class TeaDrink extends RefreshDrink {

	@Override
	/**泡制饮料*/
	protected void brew() {
		System.out.println("使用温水浸泡茶叶");
	}

	@Override
	/**加入调味料*/
	protected void addCondiments() {
		System.out.println("加入青柠檬");
	}
	
	@Override
	/**重写钩子方法,不启用父类的部分模板方法*/
	protected boolean isAddCondiments() {
		return false;
		
	}

}
