package javaAnnotation.introduce;
/**使用注解*/
@Description("这是一个类上的注解")
public class UseDescription {

	@Description(desc="我是一个描述",author="Jion",age=23, value = "我是方法上的注解")
	public void model() {
		System.out.println("使用自定义的注解");
	}
}
