package javaReflex;
/**各种类的类类型*/
public class ClassType {

	public static void main(String[] args) {
		Class<Integer> intClass = int.class;
		
		Class<String> stringClass = String.class;
		
		System.out.println("基本数据类的名字"+intClass.getSimpleName());
		System.out.println("基本数据类的全名"+intClass.getName());
		System.out.println("引用数据类的名字"+stringClass.getSimpleName());
		System.out.println("引用数据类的全名"+stringClass.getName());
	}
}
