package visitor;

/**
 * 数据,抽象层.
 * 传入访问器,子类调用访问器中的访问方法,获得结果
 *
 * @author Jion
 */
public abstract class BasePeople {

    protected String name;

    /**
     * 提供方法,让访问者可以访问
     *
     * @param action 访问者
     */
    public abstract void accept(AbstractAction action);
}
