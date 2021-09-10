package visitor;

/**
 * 访问者, 定义访问接口
 *
 * @author Jion
 */
public abstract class Action {

    /**
     * 获得一个男歌手的测评
     */
    public abstract void getManResult(Man man);

    /**
     * 获得一个女歌手的测评
     */
    public abstract void getWoManResult(Woman woman);

}
