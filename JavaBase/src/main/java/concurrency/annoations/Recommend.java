package concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author JionJion
 * 空注解,标识该类为推荐写法
 */
@Target(ElementType.TYPE)				//类方法级注解
@Retention(RetentionPolicy.SOURCE)		//编译时注解
public @interface Recommend {
	
	//默认属性
	String value() default "";
}
