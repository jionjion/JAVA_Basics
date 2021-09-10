package javaReflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 	通过反射,获得类的所有类型
 * 	*/
public class GetClassAllInfo {

	/**
	 * 打印类的所有信息
	 */
	public static void printInfo(Object object) throws Exception {
		//要获取类的信息,首先要获取类的类型
		Class<?> clazz = object.getClass();
		
		//获取类的名称
		System.out.println("传入的类名称为:"+clazz.getName());
		
		/**
		 * 	Method类,代表了对象的方法
		 * 	getMethods()方法获取的所有public的函数,包括父类继承而来的
		 * 	getDeclaredMethods()获取的是该类自己创建的方法,不问访问权限
		 * */
		Method[] methods = clazz.getMethods();
		
		//遍历所有的方法,打印其方法名,参数信息,返回值信息
		for (Method method : methods) {
			//得到其中一个方法的返回值的类类型
			Class<?> returnType = method.getReturnType();
			//获得方法名
			String methodName = method.getName();
			System.out.println("方法:"+methodName+"()\t返回值:\t"+returnType.getName());
			//获得参数列表
			Class<?>[] paramType = (Class<?>[]) method.getParameterTypes();
			System.out.print("方法:"+methodName+"()\t参数:\t");
			for (Class<?> param : paramType) {
				System.out.print(param.getName()+" ");
			}
			System.out.println();
		}
		/**	遍历所有的成员变量
		 * 	Field类封装了关于成员变量的操作
		 * 	getFields()方法获得所有的public的成员变量
		 * 	getDeclaredFields()方法获得所有的自己声明的成员变量的信息
		 * */
		
		Field[] fields = clazz.getFields();
		//遍历每一个成员变量
		for (Field field : fields) {
			Class<?> fieldType = field.getType();
			String fieldName = field.getName();
			System.out.println("成员变量的名字:"+fieldName);
			System.out.println("成员变量的类型:"+fieldType);
		}
		
		/**	遍历构造器
		 * 	Constructor封装类关于构造方法的操作
		 * 	getConstructors获得所有的public的构造函数
		 * 	getDeclaredConstructors得到所有的构造函数
		 * */
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			//获取构造函数的名字
			String constructorName = constructor.getName();
			System.out.println("构造函数的名字为:"+constructorName);
			//获得参数列表
			Class<?>[] constructorTypes = (Class<?>[]) constructor.getParameterTypes();
			System.out.print("方法:"+constructor+"()\t参数:\t");
			for (Class<?> constructorType : constructorTypes) {
				System.out.print(constructorType.getName()+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		User user = new User();
		printInfo(user);
	}
}
