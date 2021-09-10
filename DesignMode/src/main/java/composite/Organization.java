package composite;

/**
 * 定义节点方法
 *
 * @author Jion
 */
public abstract class Organization {

    /** 名字 */
    private String name;

    /** 说明 */
    private String description;

    public Organization(String name, String description){
        super();
        this.name = name;
        this.description = description;
    }

    /** 添加 */
    protected void add(Organization organization){

    }

    /** 删除 */
    protected void remove(Organization organization){

    }

    /** 子类必须实现, 抽象方法 */
    protected abstract void print();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
