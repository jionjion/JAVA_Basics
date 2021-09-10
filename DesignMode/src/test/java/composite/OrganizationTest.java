package composite;

import org.junit.Test;

/**
 *  测试, 组合模式
 * @author Jion
 */
public class OrganizationTest {

    @Test
    public void test(){
        // 大学
        Organization university = new University("河南大学", "河南自己的大学...");
        // 学院
        Organization collegeA = new College("计算机学院", "这是计算机学院");
        Organization collegeB = new College("机械学院", "这是机械学院");
        // 系
        Organization DepartmentA1 = new Department("软件工程", "这是软件工程...");
        Organization DepartmentA2 = new Department("网络工程", "这是网络工程...");
        Organization DepartmentB1 = new Department("机械制造", "这是机械制造...");
        Organization DepartmentB2 = new Department("车辆制造", "这是车辆制造...");

        // 动作组合
        collegeA.add(DepartmentA1);
        collegeA.add(DepartmentA2);
        collegeB.add(DepartmentB1);
        collegeA.add(DepartmentB2);
        university.add(collegeA);
        university.add(collegeB);

        // 组合结果, 使用学校级别, 学院级别, 学系级别
        university.print();
        collegeA.print();
        DepartmentA1.print();
    }
}