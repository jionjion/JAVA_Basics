package factory.simple;

import factory.simple.pizza.CheesePizza;
import factory.simple.pizza.GreekPizza;
import factory.simple.pizza.AbstractPizza;

/**
 * 简单工厂模式
 * 创建Pizza对象
 *
 * @author Jion
 */
public class PizzaSimpleFactory {

    private final static String CHEESE_TYPE = "CHEESE";

    private final static String GREEK_TYPE = "GREEK";

    /**
     * 根据类型不同,返回不同的子类
     */
    public AbstractPizza createPizza(String type) {
        AbstractPizza pizza = null;
        System.out.println(type);
        if (CHEESE_TYPE.equalsIgnoreCase(type)) {
            pizza = new CheesePizza();
            pizza.setName("cheese");
        } else if (GREEK_TYPE.equalsIgnoreCase(type)) {
            pizza = new GreekPizza();
            pizza.setName("greek");
        }
        return pizza;
    }
}
