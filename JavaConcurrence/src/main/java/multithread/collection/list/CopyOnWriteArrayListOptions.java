package multithread.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 场景: 演示 CopyOnWriteArrayList 读取不加锁
 *
 * @author Jion
 */
public class CopyOnWriteArrayListOptions {

    /**
     * 在 ArrayList 读取中进行修改
     */
    public void modifyArrayListOnIterate() {
        // 不能被修改
        ArrayList<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("当前数组" + list);
            String next = iterator.next();
            System.out.println("当前值" + next);

            if (next == "3") {
                // ConcurrentModificationException 不能在迭代的时候修改数组元素
                list.remove("3");
                list.add("5");
            }
        }
    }

    /**
     * 在 CopyOnWriteArrayList 读取中进行修改
     */
    public void modifyCopyOnWriteArrayListOnIterate() {
        // 可以被修改
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            // 迭代和修改内容同时进行
            System.out.println("当前数组" + list);
            String next = iterator.next();
            System.out.println("当前值" + next);

            if (next == "3") {
                // 迭代输出的结果并不收在迭代时修改的影响, 两者是不相关
                list.remove("3");
                list.add("5");
            }
        }


    }


    public static void main(String[] args) {
        // ArrayList
        new CopyOnWriteArrayListOptions().modifyArrayListOnIterate();

        // CopyOnWriteArrayList
        new CopyOnWriteArrayListOptions().modifyCopyOnWriteArrayListOnIterate();
    }
}