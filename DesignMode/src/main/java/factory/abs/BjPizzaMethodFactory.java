package factory.abs;

import factory.abs.pizza.BjCheesePizza;
import factory.abs.pizza.BjGreekPizza;
import factory.abs.pizza.AbstractPizza;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class BjPizzaMethodFactory implements AbstractPizzaFactory{

    /** 接口方法,在该子类中实现. */
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
