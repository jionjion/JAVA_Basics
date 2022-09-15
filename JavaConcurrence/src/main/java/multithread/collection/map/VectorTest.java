package multithread.collection.map;

import java.util.Vector;

/**
 * 业务: Vector 使用
 *
 * @author Jion
 */
public class VectorTest {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(4);
        vector.add("1");
        vector.add("2");
        System.out.println(vector);
    }
}
