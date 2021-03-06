package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 大学,管理下属学院
 *
 * @author Jion
 */
public class University extends BaseOrganization {

    /** 包含学院, 用抽象类代替学院实现 */
    private List<BaseOrganization> universityList = new ArrayList<BaseOrganization>();

    /** 构造器 */
    public University(String name, String description) {
        super(name, description);
    }

    /** 添加 */
    @Override
    protected void add(BaseOrganization organization){
        universityList.add(organization);
    }

    /** 删除 */
    @Override
    protected void remove(BaseOrganization organization){
        universityList.remove(organization);
    }

    /** 打印 */
    @Override
    public void print() {
        System.out.println("当前学院:" + universityList.toString());
    }
}
