package prototype.clone;

import java.io.Serializable;

/**
 * 浅拷贝
 *
 * @author Jion
 */
public class ShallowProtoType implements Serializable, Cloneable {

    // 引用类型
    private Sheep sheep;


    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public ShallowProtoType() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
