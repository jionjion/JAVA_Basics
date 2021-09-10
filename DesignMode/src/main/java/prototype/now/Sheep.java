package prototype.now;


/**
 * 原型模式,羊
 *
 * @author Jion
 */
public class Sheep implements Cloneable{
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

    /** 复制该实例 */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 默认示例
        return super.clone();
    }
}
