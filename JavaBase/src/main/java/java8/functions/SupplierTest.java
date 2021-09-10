package java8.functions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Jion
 *      供给型接口
 *          无参数, 有返回值
 */
public class SupplierTest {

    /** 获得一个字符串列表 */
    private Supplier<List<String>> getListStr = () -> {

        return Arrays.asList("a","b","c","d");
    };

    @Test
    public void testGetListStr(){
        List<String> list = getListStr.get();
        System.out.println("获得数据: " + list);
    }
}
