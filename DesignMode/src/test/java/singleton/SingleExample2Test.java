package singleton;

import org.junit.Test;

/**
 * @author Jion
 */
public class SingleExample2Test {

    @Test
    public void getInstance() {
        SingleExample2 A = SingleExample2.getInstance();

        SingleExample2 B = SingleExample2.getInstance();

        // 是否相等
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}