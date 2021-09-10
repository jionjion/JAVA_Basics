package factory.method.pizza;

/**
 * 南京希腊披萨
 *
 * @author Jion
 */
public class NJGreekPizza extends Pizza {

    @Override
    public void perpare() {
        System.out.println("南京希腊披萨准备原材料");
    }
}
