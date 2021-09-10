package prototype.now;

import org.junit.Test;

/**
 * @author Jion
 */
public class SheepTest {

    @Test
    public void test() throws CloneNotSupportedException {
        // 浅拷贝
        Sheep sheep1 = new Sheep("Jion", 1);
        Sheep sheep2 = (Sheep) sheep1.clone();
        Sheep sheep3 = (Sheep) sheep1.clone();

        // 查看
        System.out.println("sheep1 " + sheep1.toString());
        System.out.println("sheep2 " + sheep2.toString());
        System.out.println("sheep3 " + sheep3.toString());

    }
}