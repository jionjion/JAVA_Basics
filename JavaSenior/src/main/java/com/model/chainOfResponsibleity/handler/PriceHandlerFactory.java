package com.model.chainOfResponsibleity.handler;

public class PriceHandlerFactory {

	/**
	 * 	创建工厂方法
	 */
	public static PriceHandler createPriceHandler() {
		
		//创建实现类
		PriceHandler sales = new Sales();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler ceo = new CEO();
		
		//为实现类设置上级的后继
		sales.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(ceo);
		
		return sales; 	//将最底的返回
	}

}
