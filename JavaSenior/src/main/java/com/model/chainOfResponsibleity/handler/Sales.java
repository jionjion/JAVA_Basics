package com.model.chainOfResponsibleity.handler;

/**	销售人员,可以批准10%以内的折扣*/
public class Sales extends PriceHandler {

	
	/* 
	 * 	销售人员所能批准的折扣范围
	 */
	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.10) {
			System.out.println("销售人员批准了折扣:"+discount);
		}else {
			this.successor.processDiscount(discount);	//调用父类自身对象的方法,责任链向下执行
		}
		
	}

}
