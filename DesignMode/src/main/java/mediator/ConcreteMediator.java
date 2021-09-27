package mediator;

import java.util.HashMap;

/**
 * 具体的中介者
 *
 * @author Jion
 */
public class ConcreteMediator implements Mediator {

    private final HashMap<String, AbstractColleague> colleagues = new HashMap<>();

    @Override
    public void register(String name, AbstractColleague colleague) {
        colleagues.put(name, colleague);
    }


    /** 核心方法,在该方法中,完成各个子系统间的协调办公 */
    @Override
    public void getMessage(int status, String name) {
        // 根据发出消息的来源不同,处理不同的请求
        if(colleagues.get(name) instanceof Alarm){
            System.out.println("闹钟发出的消息..." + status);
        }else if(colleagues.get(name) instanceof Tv){
            System.out.println("电视发出的消息..." + status);
        }else if(colleagues.get(name) instanceof Light){
            System.out.println("电灯发出的消息..." + status);
        }else{
            System.out.println("其他消息...");
        }
    }

    @Override
    public void sendMessage() {

    }
}
