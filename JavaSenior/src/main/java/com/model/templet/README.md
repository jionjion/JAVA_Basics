# JAVA设计模式-模板方法

Tags : JDK8 Eclipse

---

[TOC]

---

## 简介
模板方法定义了一系列操作方法而延迟实现,具体的实现交由子类实现,使得子类在不改变一个算法的同时,而改变其中的特定步骤

适用场景
- 算法或者遵循相似的逻辑
- 重构代码,把相似的代码抽取到父类中
- 重要复杂的算法,核心算法设计为模板算法

优点:封装性好,复用性好,屏蔽细节,便于维护

## 文件列表
- `CoffeeDrink`  泡咖啡的子类,实现父类模板中定义的方法
- `DrinkTest`   模板方法的测试类
- `RefreshDrink` 模板方法类,定义了一系列方法
- `TeaDrink`   泡茶叶的方法,实现了父类中定义的方法

## 编码方式
### 实现功能
模拟饮料的制作过程,编写模板方法,通过子类继承模板方法并实现具体的操作方法后,完成对模板方法的调用.

| 模板方法         | 泡茶方法       | 泡咖啡方法       |
| ---------------- | -------------- | ---------------- |
| 把水煮沸         | 把水煮沸       | 把水煮沸         |
| *泡饮料*           | *用沸水浸泡茶叶* | *用沸水冲泡咖啡*   |
| 把饮料倒入杯子中 | 把茶倒进杯子里 | 把咖啡倒进杯子里 |
| *加调味料*         | *加柠檬*         |    *加糖和牛奶* |


### 定义模板方法
创建抽象类,实现共同的方法;声明一些抽象方法,交由子类具体实现;同时可以设置一些钩子来确保这些抽象方法是否真的需要去执行;最后将方法汇聚成一个`final`不可变的模板方法.

``` java
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
```

### 泡茶子类实现
继承后重写父类定义的抽象.
其中重写了钩子方法,不启用父类的个别模板方法

``` java
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
```

### 泡咖啡子类实现
继承后重写父类定义的抽象.

``` java
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
```

### 测试

``` java
public class DrinkTest {

	@Test
	public void testCoffee() {
		System.out.println("咖啡的制作开始");
		RefreshDrink coffee = new CoffeeDrink();
		coffee.RefreshDrinkTemplate();
		System.out.println("咖啡制作结束");
	}
	
	@Test
	public void testTea() {
		System.out.println("绿茶的制作开始");
		RefreshDrink tea = new TeaDrink();
		tea.RefreshDrinkTemplate();
		System.out.println("绿茶制作结束");
	}
}
```
