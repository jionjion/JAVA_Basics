package factory.old.order;

import factory.old.pizza.CheesePizza;
import factory.old.pizza.GreekPizza;
import factory.old.pizza.Pizza;

/**
 * 订购披萨
 *
 * @author Jion
 */
public class OrderPizza {

    /**
     * 订购披萨
     */
    public void order(String type) {
        Pizza pizza;
        System.out.println(type);
        if (type == "cheese") {
            pizza = new CheesePizza();
            pizza.setName("cheese");
        } else if (type == "greek") {
            pizza = new GreekPizza();
            pizza.setName("greek");
        } else {
            return;
        }
        // 准备, 烘烤, 切割, 打包
        pizza.perpare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
