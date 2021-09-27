package factory.method;

import factory.method.pizza.BjCheesePizza;
import factory.method.pizza.BjGreekPizza;
import factory.method.pizza.AbstractPizza;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class BjPizzaMethodFactory extends AbstractPizzaMethodFactory {

    /** 抽象方法,在该子类中实现. */
    @Override
    public AbstractPizza createPizza(String type){
        AbstractPizza pizza = null;
        System.out.println(type);
        if ("cheese".equalsIgnoreCase(type)) {
            pizza = new BjCheesePizza();
            pizza.setName("北京 cheese");
        } else if ("greek".equalsIgnoreCase(type)) {
            pizza = new BjGreekPizza();
            pizza.setName("北京 greek");
        }
        return pizza;
    }
}
