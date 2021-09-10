package com.model.factory.abstraction;
/**	抽象工厂的实现类,为众多工厂的其中一个
 * 	新年系列的一个*/
public class NewYearFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new ChristmasBoy();
	}

	@Override
	public Girl getGirl() {
		return new ChristmasGirl();
	}
}
