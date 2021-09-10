package java8.lambda;

import java8.lambda.interfaces.InterfaceNoParamNoReturn;
import java8.lambda.interfaces.InterfaceNoParamWithReturn;
import java8.lambda.interfaces.InterfaceWithParamNoReturn;
import java8.lambda.interfaces.InterfaceWithParamWithReturn;
import org.junit.Test;

/**
 * @author Jion
 * Lambda 表达式
 */
public class Lambda {

    /** 无参数,无返回接口调用 */
    @Test
    public void testInterfaceNoParamNoReturn() {
        // 无参数,无返回的 Lambda表达式
        final int x = 0;
        InterfaceNoParamNoReturn in = () -> {
            // 在匿名函数中,引用方法外的变量,该变量实际为final修饰的变量
            System.out.println("这是一个无参数的无返回的Lambda表达式!");
            System.out.println("通过大括号可以编写多条" + x);
        };
        in.exec();

        // 单行表达式
        InterfaceNoParamNoReturn in2 = () -> System.out.println("当只有一行代码时,大括号可以被省略!");
        in2.exec();
    }

    /** 有参数,无返回接口调用 */
    @Test
    public void testInterfaceWithParamNoReturn(){
        // 有参数,无返回值的 lambda表达式
        int i = 0;
        InterfaceWithParamNoReturn in = (x) -> {System.out.println("获得参数: x=" + x);};
        in.exec(i);

        // 当参数为一个时,参数小括号可以不写
        InterfaceWithParamNoReturn in2 = x -> System.out.println("[简写]获得参数: x=" + x);
        in2.exec(i);
    }

    /** 无参数,有返回接口调用 */
    @Test
    public void testInterfaceNoParamWithReturn(){
        // 无参数,有返回值的 Lambda表达式
        InterfaceNoParamWithReturn in = () -> {
            int i=0;
            return ++i;
        };
        int x = in.exec();
        System.out.println("执行结果: " + x);

        // 当表达式只有一行时,可以不写 return  , 这里直接返回0
        InterfaceNoParamWithReturn in2 = () -> 0;
        int y = in2.exec();
        System.out.println("执行结果: " + y);
    }



    /** 有参数,有返回值的 Lambda表达式 */
    @Test
    public void testInterfaceWithParamWithReturn(){
        // 有参数,有返回值的 Lambda表达式.
        int i = 0;
        InterfaceWithParamWithReturn in = (int x) -> {
            return ++x;
        };
        int y = in.exec(i);
        System.out.println("执行结果: " + y);

        // 单行表达式,可以省略表示中的参数类型
        InterfaceWithParamWithReturn in2 = x -> ++x;
        int y2 = in.exec(i);
        System.out.println("执行结果: " + y2);
    }
}