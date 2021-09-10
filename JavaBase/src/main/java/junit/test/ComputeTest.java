package junit.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import junit.src.Compute;

/**
 * 	使用基类,创建单元测试类
 * 		在基类上,右键,选择java->junit->junit test case ->选择测试类的位置和需要测试的方法,完成创建
 * 
 * 	测试类编码规范
 * 		1.测试方法上必须使用@Test进行修饰
 * 		2.测试方法必须使用public void 进行修饰，不能待任何的参数
 * 		3.新建一个源代码目录
 * 		4.测试类的包应该和被测试类保持一致
 * 		5.测试单元中的每个方法必须可以独立测试，测试方法间不能有任何的依赖
 * 		6.测试类使用Test作为类名的后缀
 * 		7.测试方法使用test作为方法名的前缀
 * */
public class ComputeTest {

	
	/**使用单元测试,完成断言测试*/
	@Test
	public void testdivision() {
		//简单除法计算, 3 ?= 6 / 2 
		assertEquals(3, new Compute().division (6, 2));
		System.out.println("计算成功...");
	}

}
