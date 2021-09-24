package factory.abs;

import factory.abs.pizza.BJCheesePizza;
import factory.abs.pizza.BJGreekPizza;
import factory.abs.pizza.Pizza;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class BJPizzaMethodFactory implements AbstractPizzaFactory{

    /** 接口方法,在该子类中实现. */
    @Override
    public Pizza createPizza(String type){
        Pizza pizza = null;
        System.out.println(type);
        if ("cheese".equalsIgnoreCase(type)) {
            pizza = new BJCheesePizza();
            pizza.setName("北京 cheese");
        } else if ("greek".equalsIgnoreCase(type)) {
            pizza = new BJGreekPizza();
            pizza.setName("北京 greek");
        }
        return pizza;
    }
}
