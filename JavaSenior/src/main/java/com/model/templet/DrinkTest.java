package com.model.templet;

import org.junit.Test;

/**对模板方法的测试*/
public class DrinkTest {

	@Test
	public void testCoffee() {
		System.out.println("咖啡的制作开始");
		RefreshDrink coffee = new CoffeeDrink();
		coffee.RefreshDrinkTemplate();
		System.out.println("咖啡制作结束");
	}
	
	@Test
	public void testTea() {
		System.out.println("绿茶的制作开始");
		RefreshDrink tea = new TeaDrink();
		tea.RefreshDrinkTemplate();
		System.out.println("绿茶制作结束");
	}
}
