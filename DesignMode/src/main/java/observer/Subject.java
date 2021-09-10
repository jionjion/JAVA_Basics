package observer;

/**
 *  主题
 *
 * @author Jion
 */
public interface Subject {

    /** 注册 */
    void registerObserver(Observer observer);

    /** 移除 */
    void removeObserver(Observer observer);

    /** 观察 */
    void notifyObservers(Float temperature);
}
