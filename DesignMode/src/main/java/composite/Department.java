package composite;

/**
 * 系..最小单位
 *
 * @author Jion
 */
public class Department extends BaseOrganization {

    /** 构造器 */
    public Department(String name, String description) {
        super(name, description);
    }

    /** 打印 */
    @Override
    public void print() {
        System.out.println("当前系:" + super.getName());
    }
}
