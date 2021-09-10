package lomback;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 *  \@Setter 注解使用,为非final修饰的生成setter()
 *  可以选择访问控制等级,默认的是共有方法. PUBLIC, MODULE, PROTECTED, PACKAGE, PRIVATE, NONE
 *  可以选择是否懒加载,默认false,如果懒加载需要为属性在创建时赋初值
 */
public class SetterAnnotateExample {

    @Setter(AccessLevel.PUBLIC)
    private String name;

    @Setter(AccessLevel.NONE)
    private String address;

    @Setter
    private String post;

    @Setter
    private boolean boy;

    public SetterAnnotateExample(){
        super();
    }

    @Override
    public String toString() {
        return "SetterAnnotateExample{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", post='" + post + '\'' +
                ", boy=" + boy +
                '}';
    }

    @Test
    public void testGetter(){
        SetterAnnotateExample example = new SetterAnnotateExample();
        example.setName("Jion");
        // Assert.assertNotNull(example.setAddress("ShangHai"));
        example.setPost("000A");
        Assert.assertNotNull(example.toString());
        example.setBoy(true);
        System.out.println(example.toString());
    }
}
