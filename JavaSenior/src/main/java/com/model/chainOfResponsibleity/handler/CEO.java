package com.model.chainOfResponsibleity.handler;

/**	公司老板,可以批准40%以内的折扣,否则拒绝*/
public class CEO extends PriceHandler {

	
	/* 
	 * 	销售人员所能批准的折扣范围
	 */
	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.40) {
			System.out.println("公司老板批准了折扣:"+discount);
		}else {
			System.out.println("公司老板拒绝了折扣:"+discount);	//责任链最终执行到此,都不满足,拒绝
		}
		
	}

}
