package flyweight;

/**
 * 抽象类,定义抽象方法
 *
 * @author Jion
 */
public abstract class BaseWebsite {

    /**
     * 相似的抽相方法, User为不同点
     *
     * @param user 用户类
     */
    protected abstract void use(User user);
}
