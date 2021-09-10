package factory.method;

import factory.method.pizza.BJCheesePizza;
import factory.method.pizza.BJGreekPizza;
import factory.method.pizza.Pizza;

/**
 *  抽象工厂方法,实现工厂
 * @author Jion
 */
public class BJPizzaMethodFactory extends PizzaMethodFactory{

    /** 抽象方法,在该子类中实现. */
    @Override
    public Pizza createPizza(String type){
        Pizza pizza = null;
        System.out.println(type);
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("北京 cheese");
        } else if (type.equalsIgnoreCase("greek")) {
            pizza = new BJGreekPizza();
            pizza.setName("北京 greek");
        }
        return pizza;
    }
}
