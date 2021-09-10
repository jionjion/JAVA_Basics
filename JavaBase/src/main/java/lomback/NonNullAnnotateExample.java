package lomback;

import lombok.NonNull;
import org.junit.Test;

/**
 * @author Jion
 *  \@NonNull 注解使用,用于检查变量是否为空
 */
public class NonNullAnnotateExample {


    /** 参数 name 不能为空 */
    public String sayHello(@NonNull String name){
        return ("Hello " + name.toUpperCase());
    }

    @Test
    public void testSayHello(){
        System.out.println( sayHello(null) );
    }

}
