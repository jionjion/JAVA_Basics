package javaAnnotation.introduce;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**自定义描述类注解*/



@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {		//使用@interface定义注解
							
	String desc() default "";			//当成员只有一个的时候,成员必须取名为value(),使用时可以忽略成员名和等号
							//可以没有成员,此时为标注注解
	String author() default "JION";		//成员以无参的形式进行声明
	
	int age() default 18;	//可以给定默认值
	
	String value();
}
