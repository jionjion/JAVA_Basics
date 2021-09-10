package mediator;

/**
 * 中介接口
 *
 * @author Jion
 */
public interface Mediator {

    /** 注册同事类 */
    void register(String name, Colleague colleague);

    /** 核心,处理不同家电的发送消息 */
    void getMessage(int status, String name);

    /** 发送消息 */
    void sendMessage();

}
