package factory.simple.pizza;

/**
 * 起司披萨
 *
 * @author Jion
 */
public class GreekPizza extends Pizza {

    @Override
    public void perpare() {
        System.out.println("希腊披萨准备原材料");
    }
}
