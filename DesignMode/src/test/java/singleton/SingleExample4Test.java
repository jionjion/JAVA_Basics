package singleton;

import org.junit.Test;

/**
 * @author Jion
 */
public class SingleExample4Test {

    @Test
    public void getInstance() {
        SingleExample4 A = SingleExample4.getInstance();

        SingleExample4 B = SingleExample4.getInstance();

        // 是否相等
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}