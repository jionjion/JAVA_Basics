package flyweight;

/**
 *  抽象类,定义抽象方法
 * @author Jion
 */
public abstract class Website {

    /** 相似的抽相方法, User为不同点 */
    protected abstract void use(User user);
}
