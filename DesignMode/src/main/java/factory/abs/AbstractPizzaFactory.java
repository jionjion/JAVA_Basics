package factory.abs;


import factory.abs.pizza.Pizza;

/**
 * 抽象工厂接口,定义相关依赖
 *
 * @author Jion
 */
public interface AbstractPizzaFactory {

    /**
     * 接口方法,根据不同类型,去交由子类创建
     *
     * @param type 披萨类型
     * @return 实例结果
     */
    Pizza createPizza(String type);
}
