package commons.lang.reflectDemo;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 	方法的反射调用
 */
public class MethodReflectExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		
		//创建对象
		Student student = new Student(1L, "Jion", DateUtils.parseDate("1994-4-12", "yyyy-MM-dd"));
		
		//调用无参的方法
		MethodUtils.invokeMethod(student, "sayName");
		
		//调用有参数的方法,多参数值传入参数数组即可
		MethodUtils.invokeMethod(student, "sayBirthday",new Object[] {DateUtils.parseDate("1994-4-12", "yyyy-MM-dd")});
		
		//调用有参数,有返回值的方法
		Object result = MethodUtils.invokeMethod(student, "sayIntroduce", 1);
		
		//调用静态方法
		MethodUtils.invokeMethod(student, "staticSay");
	}
}
