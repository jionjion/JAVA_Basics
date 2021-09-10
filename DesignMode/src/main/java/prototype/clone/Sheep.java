package prototype.clone;

import java.io.Serializable;

/**
 *  Cloneable 便于克隆 CloneNotSupportedException
 *  Serializable 便于序列化 NotSerializableException
 * @author Jion
 */
public class Sheep implements Cloneable, Serializable {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sheep() {
    }

    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /** 复制改实例 */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 默认示例
        return super.clone();
    }
}