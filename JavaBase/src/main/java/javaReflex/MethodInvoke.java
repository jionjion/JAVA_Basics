package javaReflex;

import java.lang.reflect.Method;

/**	
 * 	方法的反射操作
 * 	*/
public class MethodInvoke {
	
	@SuppressWarnings("unused")
	public static void  show() throws Exception{
		//获取方法对象的类类型
		Class<?> clazz = User.class;
		
		/**
		 * 	调用方法
		 * */
		//根据名称和参数列表获取参数列表
//		Method method = clazz.getMethod("play", new Class<?>[] {String.class,int.class});
		Method method = clazz.getMethod("play",String.class,int.class);		//也可以这样传入可变参数列表
		//反射调用方法,有返回值.
		//必须实例化:.newInstance()	或者,将该方法定义为static修饰的,或者传入对象 
//		Object object = method.invoke(clazz.newInstance(), new Object[]{ "王者荣耀",10});
		Object object = method.invoke(clazz.newInstance(), "王者荣耀",10);
		
		//调用无参的方法
		Method method2 = clazz.getMethod("say");	
		method2.invoke(clazz.newInstance());
	}
	
	public static void main(String[] args)throws Exception{
		
		show();
	}
}
