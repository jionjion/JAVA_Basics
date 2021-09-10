package java8.lambda.interfaces;

/**
 * @author Jion
 *      函数式接口
 *      提供有参数,无返回值的唯一方法
 */
@FunctionalInterface
public interface InterfaceWithParamNoReturn {

    void exec(int x);
}
