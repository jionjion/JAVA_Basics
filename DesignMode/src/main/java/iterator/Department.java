package iterator;

/**
 *  学系,作为迭代器遍历的对象
 * @author Jion
 */
public class Department {

    /** 名字 */
    private final String name;

    /** 描述 */
    private final String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
