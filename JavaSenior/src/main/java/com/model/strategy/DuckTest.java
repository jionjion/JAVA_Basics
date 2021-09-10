package com.model.strategy;

/**
 *	测试方法
 */
public class DuckTest {

	public static void main(String[] args) {
		
		/*测试绿头鸭*/
		Duck mallardDuck = new MallardDuck();
		mallardDuck.display();			//重写父类抽象方法后的子类方法
		mallardDuck.quack();			//父类的方法
		mallardDuck.fly();				//通过接口实现的组合方法
		
		/*测试新的橡胶鸭*/
		Duck rubberDuck = new RubberDuck();
		rubberDuck.display();			//重写父类抽象方法后子列的方法
		rubberDuck.quack();				//重写父类后子列的方法
		rubberDuck.fly();				//通过接口实现的组合方法
		
		/**测试新的大黄鸭*/
		Duck bigYellowDuck = new BigYellowDuck();
		bigYellowDuck.display();		//重写父抽象方法类后子列的方法
		bigYellowDuck.quack();			//忘记重写父类,而贸然调用了父类方法,出现问题
		bigYellowDuck.fly();			//通过接口实现的组合方法
		
		
		/**测试太空鸭*/
		Duck spaceDuck = new SpaceDuck();
		spaceDuck.display();
		spaceDuck.quack();
		spaceDuck.fly();
	}
}
