package mementor;

/**
 *  要被保存的对象
 * @author Jion
 */
public class Originator {

    /** 保存内容 */
    public String status;

    /** 保存,到备忘录中 */
    public Memento save(){
        return new Memento(status);
    }

    /** 通过备忘录中,获得对象的状态,并恢复 */
    public void recoverStatusFromMemento(Memento memento){
        this.status = memento.status;
    }
}
