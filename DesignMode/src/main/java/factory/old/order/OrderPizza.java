package factory.old.order;

import factory.old.pizza.CheesePizza;
import factory.old.pizza.GreekPizza;
import factory.old.pizza.AbstractPizza;

import java.util.Objects;

/**
 * 订购披萨
 *
 * @author Jion
 */
public class OrderPizza {

    private final static String CHEESE_TYPE = "CHEESE";

    private final static String GREEK_TYPE = "greek";

    /**
     * 订购披萨
     */
    public void order(String type) {
        AbstractPizza pizza;
        System.out.println(type);
        if (Objects.equals(type, CHEESE_TYPE)) {
            pizza = new CheesePizza();
            pizza.setName(CHEESE_TYPE);
        } else if (Objects.equals(type, GREEK_TYPE)) {
            pizza = new GreekPizza();
            pizza.setName(GREEK_TYPE);
        } else {
            return;
        }
        // 准备, 烘烤, 切割, 打包
        pizza.prepared();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
