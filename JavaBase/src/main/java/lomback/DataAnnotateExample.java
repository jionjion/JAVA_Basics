package lomback;

import lombok.Data;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 *  \@Data 注解.
 *      包含
 *          \@Getter，
 *          \@Setter所有非final字段,
 *          \@RequiredArgsConstructor,
 *          \@EqualsAndHashCode,
 *          \@ToString,
 */
public class DataAnnotateExample {

    @Data
    class UserA{

        @NonNull
        private int id;

        @NonNull
        private String name;

        private String address;
    }

    @Test
    public void testUserA(){
        // @RequiredArgsConstructor 要求@NonNull注解的字段作为构造函数
        UserA userA = new UserA(1,"Jion");

        // @Setter
        userA.setAddress("HeNan");

        // @Getter
        Assert.assertNotNull(userA.getAddress());

        // @EqualsAndHashCode
        System.out.println(userA.hashCode());

        // @ToString
        System.out.println(userA.toString());
    }
}
