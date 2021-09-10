package mementor;

/**
 *  状态封装类
 * @author Jion
 */
public class Memento {

    /** 保存对象的属性 */
    public String status;

    Memento(String status){
        this.status = status;
    }
}
