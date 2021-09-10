package com.model.factory.general;
/**发型工厂*/
public class HairFactory {

	/**根据传入参数来创建对象,实现父类接口*/
	public HairInterface getHairByString(String key) {
		if ("left".equals(key)) {
			return new LeftHair();
		} else if ("right".equals(key)) {
			return new RightHair();
		} else {
			return null;
		}
	}
	
	/**根据传入类的名来创建对象
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException */
	public HairInterface getHairByClass(Class<?> c) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String className = c.getName();
		//父类接口,指向根据类名动态加载的子类的创建实例
		HairInterface hair = (HairInterface) Class.forName(className).newInstance();
		return hair;
	}
}
