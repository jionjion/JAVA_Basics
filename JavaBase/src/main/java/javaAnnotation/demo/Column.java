package javaAnnotation.demo;
/**表示字段注解*/
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})				//字段上的注解
@Retention(RetentionPolicy.RUNTIME)		//运行时注解
public @interface Column {

	String value();
}
