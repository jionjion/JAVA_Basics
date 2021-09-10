package java8.functions;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author Jion
 *      断言型接口
 *          有参数, 返回布尔值
 */
public class PredicateTest {


    /**
     *  断言
     *      boolean test(T t);
     *          是否大写
     */
    private Predicate<String> isUpperCase = (t) -> t.toUpperCase().equals(t);

    /** 是否为单字符 */
    private Predicate<String> isSingle = (t) -> t.length()==1;

    /** 测试断言 */
    @Test
    public void testIsUpperCase(){
        Boolean result = isUpperCase.test("A");
        System.out.println("是否大写: " + result);
    }

    /** and */
    @Test
    public void testAnd(){
        Boolean result = isUpperCase.and(isSingle).test("A");
        System.out.println("是否大写且为单字符: " + result);
    }

    /** or */
    @Test
    public void testOr(){
        Boolean result = isUpperCase.or(isSingle).test("AA");
        System.out.println("是否大写或为单字符: " + result);
    }


    /** not */
    @Test
    public void testNot(){
        Boolean result = isUpperCase.negate().test("AA");
        System.out.println("是否不为大写: " + result);
    }




}
