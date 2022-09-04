package collection.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * 业务: Hashtable 的使用
 *
 * @author Jion
 */
public class HashtableTest {

    public static void main(String[] args) {
        Map<String, String> table = new Hashtable<>();

        table.put("Hello", "World");

        System.out.println(table.get("Hello"));
    }
}
