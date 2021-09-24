package commons.lang.reflectDemo;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.time.DateUtils;

public class FieldReflectExample {

	public static void main(String[] args) throws Exception{

        Student student = new Student(1L, "Jion", DateUtils.parseDate("1994-4-12", "yyyy-MM-dd"));
   
        // 以下两个方法完全一样,都能获取共有或私有变量,因为第三个参数都设置了忽略私有性
        FieldUtils.getDeclaredField(Student.class, "name", true);    
        FieldUtils.getField(Student.class, "name", true);    
   
        // 读取私有或公共变量的值    
        FieldUtils.readField(student, "name", true);
   

        // 写入静态变量    
        FieldUtils.writeStaticField(Student.class, "hashCode", "学生类");
        
        // 读取静态变量    
        FieldUtils.readStaticField(Student.class, "hashCode");    
   
        // 写入私有或共有变量    
        FieldUtils.writeField(student, "name", "JION", true);
   
	}	
}
