package factory.method;

import factory.method.pizza.Pizza;

/**
 *  抽象工厂方法,抽象工厂
 * @author Jion
 */
public abstract class PizzaMethodFactory {

    /** 抽象方法,根据不同类型,去交由子类创建 */
    protected abstract Pizza createPizza(String type);

}
