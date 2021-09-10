package factory.method.pizza;

/**
 * 北京起司披萨
 *
 * @author Jion
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void perpare() {
        System.out.println("北京的起司披萨准备原材料");
    }
}
