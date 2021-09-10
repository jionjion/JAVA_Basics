package lomback;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 *  \@Getter 注解使用
 *  可以选择访问控制等级,默认的是共有方法. PUBLIC, MODULE, PROTECTED, PACKAGE, PRIVATE, NONE
 *  可以选择是否懒加载,默认false,如果懒加载需要为属性在创建时赋初值
 */
public class GetterAnnotateExample {

    @Getter(AccessLevel.PUBLIC)
    private String name = "Jion";

    @Getter(AccessLevel.NONE)
    private String address = "ShangHai";

    @Getter(lazy = true)
    private final String post = "000A";

    /** 注意boolean类型的为is */
    @Getter
    private boolean boy = false;

    public GetterAnnotateExample(){
        super();
    }

    @Test
    public void testGetter(){
        GetterAnnotateExample example = new GetterAnnotateExample();
        Assert.assertNotNull(example.getName());
        System.out.println(example.getName());
        // Assert.assertNotNull(example.getAddress());
        Assert.assertNotNull(example.getPost());
        System.out.println(example.getPost());
        System.out.println(example.isBoy());
    }
}
