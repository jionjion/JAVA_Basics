package prototype.clone;

import java.io.*;

/**
 *  深拷贝
 * @author Jion
 */
public class DeepProtoType implements Serializable, Cloneable {

    // 引用类型
    private Sheep sheep;

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public DeepProtoType() {

    }

    /** 深拷贝, 重写Clone方法 */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 返回对象
        Object deepProto = null;
        // 1.调用父类的clone方法,对基础数据类型进行浅拷贝
        deepProto = super.clone();
        DeepProtoType clone = (DeepProtoType) deepProto;
        // 2.单独处理引用类型的成员属性
        clone.setSheep((Sheep) this.sheep.clone());
        return super.clone();
    }

    /** 深拷贝,通过序列化 */
    public Object deepClone() throws IOException, ClassNotFoundException {
        // 字节对象
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // 序列化对象
        objectOutputStream.writeObject(this);
        // 反序列化对象
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        // 返回结果
        return objectInputStream.readObject();
    }
}
