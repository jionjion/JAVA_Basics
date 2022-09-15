package multithread.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 业务: 使用 Collections.synchronizedList 包装列表, 使之成为线程安全的容器
 *
 * @author Jion
 */
public class SynList {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
    }
}
