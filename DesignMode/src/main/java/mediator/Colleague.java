package mediator;

/**
 * 同事类,定义各子家电共有方法,维持中介类
 *
 * @author Jion
 */
public abstract class Colleague {

    /** 中介类 */
    private final Mediator mediator;

    /** 家电名 */
    public String name;

    public Colleague(Mediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    /** 发送信号 */
    public abstract void sendMessage(int status);
}
