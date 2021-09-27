package factory.abs;

import factory.abs.pizza.NjCheesePizza;
import factory.abs.pizza.NjGreekPizza;
import factory.abs.pizza.AbstractPizza;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class NjPizzaMethodFactory implements AbstractPizzaFactory{

    /** 接口方法,在该子类中实现. */
    @Override
    public AbstractPizza createPizza(String type){
        AbstractPizza pizza = null;
        System.out.println(type);
        if ("cheese".equalsIgnoreCase(type)) {
            pizza = new NjCheesePizza();
            pizza.setName("南京 cheese");
        } else if ("greek".equalsIgnoreCase(type)) {
            pizza = new NjGreekPizza();
            pizza.setName("南京 greek");
        }
        return pizza;
    }
}
