package concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 空注解,标识该类为线程不安全
 * 类方法级注解 ;编译时注解
 *
 * @author JionJion
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    //默认属性
    String value() default "";
}
