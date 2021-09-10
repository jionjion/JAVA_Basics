package com.model.chainOfResponsibleity;

import java.util.Random;

import com.model.chainOfResponsibleity.handler.PriceHandler;
import com.model.chainOfResponsibleity.handler.PriceHandlerFactory;

/**	客户类*/
public class Customer {
	
	private PriceHandler priceHandler;
	
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	
	/**	请求折扣*/
	public void requestDiscount(float discount) {
		priceHandler.processDiscount(discount);  		//使用父类完成
	}

	
	
	/**客户执行折扣请求*/
	public static void main(String[] args) {
		Customer customer = new Customer();				//客户
		PriceHandler priceHandler = PriceHandlerFactory.createPriceHandler();
		customer.setPriceHandler(priceHandler); 		//为客户设置销售
		
		Random random = new Random();
		for(int i=1 ; i<= 100 ; i++){
			System.out.println("第"+i+"次:");
			customer.requestDiscount(random.nextFloat());
		}
	}
}
