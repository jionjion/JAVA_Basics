package factory.method;

import factory.method.pizza.AbstractPizza;

/**
 * 抽象工厂方法,抽象工厂
 *
 * @author Jion
 */
public abstract class AbstractPizzaMethodFactory {

    /**
     * 抽象方法,根据不同类型,去交由子类创建
     *
     * @param type 类型
     * @return 返回类型对应实例
     */
    protected abstract AbstractPizza createPizza(String type);

}
