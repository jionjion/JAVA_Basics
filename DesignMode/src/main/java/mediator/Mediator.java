package mediator;

/**
 * 中介接口
 *
 * @author Jion
 */
public interface Mediator {

    /**
     * 注册同事类
     *
     * @param name      中介名
     * @param colleague 同事类,各种家电子系统
     */
    void register(String name, Colleague colleague);

    /**
     * 核心,处理不同家电的发送消息
     *
     * @param status 状态消息
     * @param name   家电名称
     */
    void getMessage(int status, String name);

    /**
     * 发送消息
     */
    void sendMessage();
}
