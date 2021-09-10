package commons.lang.reflectDemo;

import org.apache.commons.lang3.ClassUtils;

/**
 * 	类信息的反射
 * @author JionJion
 */
public class ClassReflectExample {

	public static void main(String[] args) {
		
        // 获取Student类所有实现的接口    
        ClassUtils.getAllInterfaces(Student.class);    
   
        // 获取Student类所有父类    
        ClassUtils.getAllSuperclasses(Student.class);    
   
        // 获取Student类所在的包名    
        ClassUtils.getPackageName(Student.class);    
   
        // 获取Student类简单类名    
        ClassUtils.getShortClassName(Student.class);    
   
        // 判断是否可以转型    
        ClassUtils.isAssignable(Student.class, Object.class);    
   
        // 判断是否有内部类    
        ClassUtils.isInnerClass(Student.class);  		
		
	}
}
