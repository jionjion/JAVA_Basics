package singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jion
 */
public class SingleExample1Test {

    @Test
    public void getInstance() {
        SingleExample1 A = SingleExample1.getInstance();

        SingleExample1 B = SingleExample1.getInstance();

        // 是否相等
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}