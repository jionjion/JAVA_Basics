package singleton;

import org.junit.Test;

/**
 * @author Jion
 */
public class SingleExample6Test {

    @Test
    public void getInstance() {
        SingleExample6 A = SingleExample6.INSTANCE;

        SingleExample6 B = SingleExample6.INSTANCE;

        // 是否相等
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}