package javaAnnotation.introduce;

import java.lang.reflect.Method;

/**解析注解,只能解析运行时注解*/
public class ParseDescription {

	public static void main(String[] args) throws Exception {
		//使用类加载器加载类
		Class<?> clazz  = Class.forName("javaAnnotation.introduce.UseDescription");
		
		//找到类上的注解,判断是否存在
		boolean isExist = clazz.isAnnotationPresent(Description.class);
		//拿到注解实例
		if (isExist) {
			//获得注解对象
			Description description = (Description) clazz.getAnnotation(Description.class);
			System.out.println("类上注解的默认Value为:"+description.value());
		}
		
		//找到方法上的注解,默认对每个方法进行遍历,不仅限于自定义的方法
		Method[] method = clazz.getMethods();
		for (Method m : method) {
			boolean isExis = m.isAnnotationPresent(Description.class);
			if (isExis) {
				Description description = (Description) m.getAnnotation(Description.class);
				System.out.println("获取方法上的注解:"+description.value());
			}
		}
	}
}
