package mediator;

/**
 * 电视,具体同事类
 *
 * @author Jion
 */
public class Tv extends AbstractColleague {

    public Tv(Mediator mediator, String name) {
        super(mediator, name);
        // 创建具体同事类时,将自己注入到中介类中.
        mediator.register(name, this);
    }

    /** 发送消息 */
    public void sendAlarm(int status){
        sendMessage(status);
    }

    @Override
    public void sendMessage(int status) {
        // 得到中介,并处理相应消息
        this.getMediator().getMessage(status, this.name);
    }
}
