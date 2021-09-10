package com.model.factory.abstraction;
/**模拟客户端*/
public class Client {

	/**			新年系列		圣诞系列
	 * 	男孩子	  √
	 * 	女孩子				  √
	 * 									*/
	
	public static void main(String[] args) {
		PersonFactory factory = new NewYearFactory();
		Boy boy = factory.getBoy();
		boy.drawBoy();
	}
}
