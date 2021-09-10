package lomback;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 */
public class ToStringAnnotateExample {


    /** 将构造函数和字段名称全部输出 */
    @ToString(callSuper = true, includeFieldNames = true)
    class UserA {

        public int id;

        public String name;

        public String address;

        public UserA(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }

    @Test
    public void testUserA(){
        UserA userA = new UserA(1,"Jion","ShangHai");
        Assert.assertNotNull(userA.toString());
        System.out.println(userA.toString());
    }

    /** 当exclude和of同时使用时,exclude会被忽略
     *  exclude 排除那些属性可以被输出
     *  of      指定那些属性可以被输出,未被包括属性的不输出
     */
    @ToString(exclude = {"id"},of = {"name"})
    class UserB {
        public int id;

        public String name;

        public String address;
    }

    @Test
    public void testUserB(){
        UserB userB = new UserB();
        userB.id = 1;
        userB.name = "Jion";
        userB.address = "ShangHai";
        Assert.assertNotNull(userB.toString());
        System.out.println(userB.toString());
    }

    /** doNotUseGetters 当进行toString时,如果为true则不使用getter方法获得属性值,而是直接访问.
     *                  默认false,即通过getter方法获得属性值,无论get方法是否存在 */
    @ToString(doNotUseGetters = false)
    class UserC {
        private int id;

        private String name;

        private String address;

        public UserC(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }

    @Test
    public void testUserC(){
        UserC userC = new UserC(1,"Jion","ShangHai");
        Assert.assertNotNull(userC.toString());
        System.out.println(userC.toString());
    }

    /**
     *  onlyExplicitlyIncluded 默认false.
     *      当为true时,只有被\@ToString.Include 标注的属性才会被输出
     *  \@ToString.Exclude 属性不被输出
     *  \@ToString.Include 属性被输出
     *  */
    @ToString(onlyExplicitlyIncluded = true)
    class UserD{

        @ToString.Exclude
        public int id;

        @ToString.Include
        public String name;

        public String address;

        public UserD(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }
    @Test
    public void testUserD(){
        UserD userD = new UserD(1,"Jion","ShangHai");
        Assert.assertNotNull(userD.toString());
        System.out.println(userD.toString());
    }
}
