package lomback;

import lombok.Value;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 *  \@Value 注解 不可变的数据体
 *      \@AllArgsConstructor
 *      \@Gette
 *      \@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
 *      \@EqualsAndHashCode
 *      \@ToString
 */
public class ValueAnnotateExample {

    @Value
    class UserA{

        private int id;

        private String name;

        private String address;

    }

    @Test
    public void testUserA(){
        // @AllArgsConstructor
        UserA userA = new UserA(1,"Jion","HeNan");

        // @Gette
        Assert.assertNotNull(userA.getName());

        // @EqualsAndHashCode
        System.out.println(userA.hashCode());

        // @ToString
        System.out.println(userA.toString());
    }
}
