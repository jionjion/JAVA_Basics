package factory.method;

import factory.method.pizza.*;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class NJPizzaMethodFactory extends PizzaMethodFactory{

    /** 抽象方法,在该子类中实现. */
    @Override
    public Pizza createPizza(String type){
        Pizza pizza = null;
        System.out.println(type);
        if ("cheese".equalsIgnoreCase(type)) {
            pizza = new NJCheesePizza();
            pizza.setName("南京 cheese");
        } else if ("greek".equalsIgnoreCase(type)) {
            pizza = new NJGreekPizza();
            pizza.setName("南京 greek");
        }
        return pizza;
    }
}
