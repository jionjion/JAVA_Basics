package singleton;

import org.junit.Test;

/**
 * @author Jion
 */
public class SingleExample3Test {

    @Test
    public void getInstance() {
        SingleExample3 A = SingleExample3.getInstance();

        SingleExample3 B = SingleExample3.getInstance();

        // 是否相等
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}