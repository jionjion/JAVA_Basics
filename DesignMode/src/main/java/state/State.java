package state;

/**
 * 状态接口,定义操作
 *
 * @author Jion
 */
public interface State {

    /** 新建状态 */
    default void doInit(){ }

    /** 工作状态 */
    void doWork();

    /** 销毁状态 */
    void doDestroy();
}
