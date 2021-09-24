package factory.abs;

import factory.abs.pizza.NJCheesePizza;
import factory.abs.pizza.NJGreekPizza;
import factory.abs.pizza.Pizza;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class NJPizzaMethodFactory implements AbstractPizzaFactory{

    /** 接口方法,在该子类中实现. */
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
