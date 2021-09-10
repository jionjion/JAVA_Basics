package com.model.templet;

/**
 *	抽象基类,为所有子类提供一个算法框架
 */
public abstract class RefreshDrink {

	/**
	 * 	制备饮料的模板方法,修饰为final,并以template结尾,声明其为模板方法.
	 * 	将共性的方法声明为私有方法,实现将共同的方法固化在高层代码,而子类不需要关心过多的细枝末节.
	 * 	封装了所有子类共同遵守的算法框架
	 */
	public final void RefreshDrinkTemplate() {
		//第一步:将水煮沸
		boilWater();
		//第二步:泡制饮料
		brew();
		//第三部:将饮料导入杯中
		pourInCup();
		//第四步:询问用户是否加入调味料
		if (isAddCondiments()) {			//钩子方法,是否暴露实现
			addCondiments();
		}
	}
	/**将水煮沸,共性方法,声明为私有,子类无需关注*/
	private void boilWater() {
		System.out.println("将水煮沸了...........");
	}

	/**泡制饮料,子类实现,使用protected修饰,只允许子类实现,同时声明为抽象方法*/
	protected abstract void brew();

	/**将饮料导入杯中,共性方法,声明为私有,子类无需关注*/
	private void pourInCup() {
		System.out.println("将饮料导入杯子...........");
	}

	/**加入调味料,子类实现,使用protected修饰,只允许子类实现,同时声明为抽象方法*/
	protected abstract void addCondiments();

	/**钩子方法,询问用户是否加入调料,使用protected修饰,这样可以交由子类选择是否启用父类模板中的某些方法*/
	protected boolean isAddCondiments() {
		return true;	//默认执行
	}
}
