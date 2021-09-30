package factory.method;

import factory.method.pizza.*;

/**
 * 抽象工厂方法,实现工厂
 *
 * @author Jion
 */
public class NjPizzaMethodFactory extends AbstractPizzaMethodFactory {

    private final static String CHEESE_TYPE = "CHEESE";

    private final static String GREEK_TYPE = "GREEK";

    /**
     * 抽象方法,在该子类中实现.
     */
    @Override
    public AbstractPizza createPizza(String type) {
        AbstractPizza pizza;
        switch (type) {
            case CHEESE_TYPE:
                pizza = new BjCheesePizza();
                pizza.setName("南京 cheese");
                break;
            case GREEK_TYPE:
                pizza = new BjGreekPizza();
                pizza.setName("南京 greek");
                break;
            default:
                pizza = null;
                break;
        }
        return pizza;
    }
}
