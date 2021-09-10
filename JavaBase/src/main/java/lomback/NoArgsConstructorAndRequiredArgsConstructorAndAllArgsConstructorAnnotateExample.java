package lomback;

import lombok.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 * \@NoArgsConstructor 无参数构造注解.
 *      access 构造器是修饰符
 *      force  对于final修饰的变量赋值 0/false/null
 *      staticName 是否对外提供工厂类方法.
 * \@RequiredArgsConstructor 需要的构造注解
 *      会对 @NonNull 修饰的参数生成注解
 * \@ AllArgsConstructor  构造方法包含每一个参数
 *
 */
public class NoArgsConstructorAndRequiredArgsConstructorAndAllArgsConstructorAnnotateExample {

    @NoArgsConstructor
    class UserA{
        public int id;

        public String name;

        public String address;
    }
    @Test
    public void testUserA(){
        // 默认的无参数的构造方法
        UserA userA = new UserA();
        Assert.assertNotNull(userA);
    }

    @NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
    class UserB{
        public int id;

        public String name;

        public final String address;
    }

    @Test
    public void testUserB(){
        UserB userB1 = new UserB();
        Assert.assertNotNull(userB1);
        Assert.assertNull(userB1.address);
    }

    @RequiredArgsConstructor(access = AccessLevel.PUBLIC)
    class UserC{

        @NonNull
        public int id;

        @NonNull
        public String name;

        public String address;
    }

    @Test
    public void testUserC(){
        UserC userC = new UserC(1,"Jion");
        Assert.assertNull(userC.address);
        Assert.assertNotNull(userC);
    }

    @AllArgsConstructor
    class UserD{
        public int id;

        public String name;

        public String address;
    }

    @Test
    public void testUserD(){
        UserD userD = new UserD(1,"Jion","HeNan");
        Assert.assertNotNull(userD);
    }



    /*
    @Test
    public void testUser(){
        User user = User.of();
        Assert.assertNotNull(user);
    }
    */
}

/*
测试 staticName 静态方法
@NoArgsConstructor(staticName = "of")
class User{

    @NonNull
    private int id;

    @NonNull
    private String name;

    private String address;
}
*/