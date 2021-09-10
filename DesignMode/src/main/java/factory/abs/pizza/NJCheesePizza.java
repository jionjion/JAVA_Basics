package factory.abs.pizza;

import factory.abs.NJPizzaMethodFactory;

/**
 * 南京起司披萨
 *
 * @author Jion
 */
public class NJCheesePizza extends Pizza {

    @Override
    public void perpare() {
        System.out.println("南京起司披萨准备原材料");
    }
}
