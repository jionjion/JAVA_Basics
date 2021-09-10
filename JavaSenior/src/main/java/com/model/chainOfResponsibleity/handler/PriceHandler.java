package com.model.chainOfResponsibleity.handler;

/**	价格处理人,处理客户的折扣申请*/
public abstract class PriceHandler {

	/*	直接后继,用来传递请求*/
	protected PriceHandler successor;		//代表了该类对象,可以调用自身方法

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
	
	/**
	 * 	处理折扣申请
	 */
	public abstract void processDiscount(float discount);
	
}
