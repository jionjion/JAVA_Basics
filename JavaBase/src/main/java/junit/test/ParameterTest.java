package junit.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.src.Compute;

/**	参数化测试*/
@RunWith(Parameterized.class)		//1.改变运行环境
public class ParameterTest {

	//2.声明变量存放预期值和参数
	int result = 0;
	int param1 = 4;
	int param2 = 2;
	//3.使用变量和预期值作为构造函数,并赋值
	public ParameterTest(int result, int param1, int param2) {
		super();
		this.result = result;
		this.param1 = param1;
		this.param2 = param2;
	}
	
	
	//4.声明返回值为集合类的静态方法,作为参数,并修饰
	@Parameters
	public static Collection<Object[]> returnList() {
		
		List<Object[]> list = new ArrayList<Object[]>();		//作为返回值
		Object[][] objects = new Object[][]{{2,2,1},{3,9,3}};	//创建一个二维数组,保存为变量和结果	2=2/1  3=9/3
		list = Arrays.asList(objects);
		return list;
	}

	//5.传入类中的变量,完成赋值,进行断言
	@Test
	public void testdivision() {
		//使用有参的方式,传入一个List
		assertEquals(result, new Compute().division (param1, param2));
		System.out.println("计算成功...");
	}
}
