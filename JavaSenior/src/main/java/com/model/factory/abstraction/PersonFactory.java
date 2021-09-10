package com.model.factory.abstraction;
/**接口,有不同的工厂,为抽象工厂模式 */
public interface PersonFactory {

	/**男孩子接口*/
	public Boy getBoy();
	
	/**女孩子接口*/
	public Girl getGirl();
}
