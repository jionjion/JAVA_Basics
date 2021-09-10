package singleton;

import org.junit.Test;

/**
 * @author Jion
 */
public class SingleExample5Test {

    @Test
    public void getInstance() {
        SingleExample5 A = SingleExample5.getInstance();

        SingleExample5 B = SingleExample5.getInstance();

        // 是否相等
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}