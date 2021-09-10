package lomback;

import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 *  \@EqualsAndHashCode 注解
 */
public class EqualsAndHashCodeAnnotateExample {

    /** 父类 */
    class User{

    }
    /** 子类
     *  \@EqualsAndHashCode 默认callSuper=false
     *  当为false时,只比对子类之间的属性值差异,而不比较继承的父类
     *  当为true时,如果继承的父类实例一致,则返回相同的hashcode */
    @EqualsAndHashCode(callSuper = false)
    class UserA extends User{

        public int id;

        public String name;

        public String address;

        public UserA(int id, String name, String address) {
            super();
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }

    @Test
    public void testUserA(){
        UserA userA1 = new UserA(1,"Jion","ShangHai");
        UserA userA2 = new UserA(1,"Jion","ShangHai");
        Assert.assertEquals(userA1.hashCode(), userA2.hashCode());
        System.out.println(userA1.hashCode());
        System.out.println(userA2.hashCode());
    }

    /** 当exclude和of同时使用时,exclude会被忽略
     *  exclude 排除那些属性比较
     *  of      指定那些属性比较,未被包括属性的不进行比较
     *
     */
    @EqualsAndHashCode(exclude = {"id"}, of = {"name"})
    class UserB{
        public int id;

        public String name;

        public String address;

        public UserB(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }

    @Test
    public void testUserB(){
        UserB userB1 = new UserB(1,"Jion","HeNan");
        UserB userB2 = new UserB(2,"Jion","ShangHai");
        Assert.assertEquals(userB1.hashCode(), userB2.hashCode());
        System.out.println(userB1.hashCode());
        System.out.println(userB2.hashCode());
    }

    /** doNotUseGetters 当进行toString时,如果为true则不使用getter方法获得属性值,而是直接访问.
     *                  默认false,即通过getter方法获得属性值,无论get方法是否存在 */
    @EqualsAndHashCode(doNotUseGetters = true)
    class UserC{
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
        UserC userC1 = new UserC(1,"Jion","HeNan");
        UserC userC2 = new UserC(2,"Jion","HeNan");
        Assert.assertNotEquals(userC1.hashCode(), userC2.hashCode());
        System.out.println(userC1.toString());
        System.out.println(userC2.toString());
    }

    /**
     *  onlyExplicitlyIncluded 默认false.
     *      当为true时,只有被\@EqualsAndHashCode.Include 标注的属性才会被比较
     *  \@EqualsAndHashCode.Exclude 属性不被比较
     *  \@EqualsAndHashCode.Include 属性被比较
     *  */
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    class UserD{
        @EqualsAndHashCode.Exclude
        private int id;

        @EqualsAndHashCode.Include
        private String name;

        private String address;

        public UserD(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }

    @Test
    public void testUserD(){
        UserD userD1 = new UserD(1,"Jion","HeNan");
        UserD userD2 = new UserD(2,"Jion","ShangHai");
        Assert.assertEquals(userD1.hashCode(), userD2.hashCode());
        System.out.println(userD1.toString());
        System.out.println(userD2.toString());
    }
}
