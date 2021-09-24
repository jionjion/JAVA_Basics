package factory.method.pizza;

/**
 * 北京起司披萨
 *
 * @author Jion
 */
public class BjCheesePizza extends Pizza {

    @Override
    public void prepared() {
        System.out.println("北京的起司披萨准备原材料");
    }
}
