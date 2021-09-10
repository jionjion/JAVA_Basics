package factory.simple;

import factory.simple.pizza.CheesePizza;
import factory.simple.pizza.GreekPizza;
import factory.simple.pizza.Pizza;

/**
 * 简单工厂模式
 * 创建Pizza对象
 *
 * @author Jion
 */
public class PizzaSimpleFactory {

    /**
     * 根据类型不同,返回不同的子类
     */
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        System.out.println(type);
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("cheese");
        } else if (type.equalsIgnoreCase("greek")) {
            pizza = new GreekPizza();
            pizza.setName("greek");
        }
        return pizza;
    }
}
