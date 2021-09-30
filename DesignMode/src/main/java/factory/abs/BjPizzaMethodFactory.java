package factory.abs;

import factory.abs.pizza.BjCheesePizza;
import factory.abs.pizza.BjGreekPizza;
import factory.abs.pizza.AbstractPizza;

/**
 * 抽象工厂方法,实现工厂
 *
 * @author Jion
 */
public class BjPizzaMethodFactory implements AbstractPizzaFactory {

    private final static String CHEESE_TYPE = "CHEESE";

    private final static String GREEK_TYPE = "GREEK";

    /**
     * 接口方法,在该子类中实现.
     */
    @Override
    public AbstractPizza createPizza(String type) {
        System.out.println(type);
        if (CHEESE_TYPE.equalsIgnoreCase(type)) {
            AbstractPizza pizza = new BjCheesePizza();
            pizza.setName("北京 cheese");
            return pizza;
        } else if (GREEK_TYPE.equalsIgnoreCase(type)) {
            AbstractPizza pizza = new BjGreekPizza();
            pizza.setName("北京 greek");
            return pizza;
        }
        return null;
    }
}
