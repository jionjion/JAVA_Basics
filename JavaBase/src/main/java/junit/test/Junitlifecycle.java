package junit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
/**
 * 	单元测试的运行周期
 */
public class Junitlifecycle {

/**测试周期*/
	
	/**静态方法,在类初始化时执行,适合加载各种配置*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("类实初始化前创建,只执行一次");
	}

	/**前面的通用代码块*/
	@Before
	public void setUp() throws Exception {
		System.out.println("测试方法前执行,执行多次");
	}

	@Test
	public void test1() {
		System.out.println("测试代码1....");
	}
	
	@Ignore("不执行该方法")				//被该注解修饰后,不再执行
	@Test
	public void test2() {
		System.out.println("测试代码2....");
	}
	/**后面的通用代码块*/
	@After
	public void tearDown() throws Exception {
		System.out.println("测试方法后执行,执行多次");
	}

	/**对资源的清理,关闭各种连接*/
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("类销毁时创建,只执行一次");
	}
	
}
