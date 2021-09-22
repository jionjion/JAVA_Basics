package concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * 	示例
 *		对象溢出
 *			这里在对象内部实例化了其他对象,因此在引用改对象时,内部对象尚未实例化,容易出现对象溢出
 *		修改方法
 *			改为static修饰为静态方法,或者使用工厂方法创建
 */
@Slf4j
public class PublishExample2 {

	//私有属性
	private int thisCanBeEscape = 1;
	
	//构造函数,实例化内部类
	public PublishExample2() {
		new InnerClass();
	}
	
	/** 内部类 */
	private class InnerClass{
		
		//内部类构造函数
		public InnerClass() {
			//调用外部类对象的私有属性
			log.info("{}",PublishExample2.this.thisCanBeEscape);
		}
	}
	
	public static void main(String[] args) {
		PublishExample2 example2 = new PublishExample2();
	}
}
