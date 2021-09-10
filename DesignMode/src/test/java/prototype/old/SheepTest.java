package prototype.old;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 传统方式,拷贝
 *
 * @author Jion
 */
public class SheepTest {

    @Test
    public void test() {
        Sheep sheep1 = new Sheep("Jion", 1);
        // 拷贝
        Sheep sheep2 = new Sheep(sheep1.getName(), sheep1.getAge());
        Sheep sheep3 = new Sheep(sheep1.getName(), sheep1.getAge());
        Sheep sheep4 = new Sheep(sheep1.getName(), sheep1.getAge());

        // 查看
        System.out.println("sheep1 " + sheep1.toString());
        System.out.println("sheep2 " + sheep2.toString());
        System.out.println("sheep3 " + sheep3.toString());
        System.out.println("sheep4 " + sheep4.toString());
    }
}