package com.model.chainOfResponsibleity.handler;

/**	销售总监,可以批准30%以内的折扣*/
public class Director extends PriceHandler {

	
	/* 
	 * 	销售人员所能批准的折扣范围
	 */
	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.30) {
			System.out.println("销售经理批准了折扣:"+discount);
		}else {
			this.successor.processDiscount(discount);	//调用父类自身对象的方法,责任链向下执行
		}
		
	}

}
