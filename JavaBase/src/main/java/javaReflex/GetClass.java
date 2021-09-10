package javaReflex;


/**	怎样获取类类型
 * 
 * 	类的对象为Class类的对象,称为类的类类型
 * 	类类型,为单例模式,一个类只能是Class类的唯一表达*/
public class GetClass {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) throws Exception{
		
		User user = new User();
	
		/**
		 * 	获取类类型的方式,这里三种方式获得的结果均相同
		 * */
		
		//第一种方式
		Class clazz1 = User.class;
		
		//第二种方式
		Class clazz2 = user.getClass();
		
		//第三种方式
		Class clazz3 = Class.forName("javaReflex.User");
		
		
		/**
		 * 	通过类类型,可以创建类的对象
		 * 	前提该类必须有一个无参的构造器
		 * 	需要强制类型转换
		 * */
		
		User user2 = (User)clazz2.newInstance();
	}
}
