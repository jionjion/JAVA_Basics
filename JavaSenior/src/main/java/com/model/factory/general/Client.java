package com.model.factory.general;
/**客户端,进行调用*/
public class Client {

	public static void main(String[] args) throws Exception {
		
		HairFactory factory = new HairFactory();
		//多态,父类接口指向子类,具体的子类创建交由工厂创建
//		HairInterface left = factory.getHairByString("left");
		
		//
		HairInterface left = factory.getHairByClass(MiddleHair.class);
		left.drawHair();
	}
}
