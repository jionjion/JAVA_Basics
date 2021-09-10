package iterator;

import org.junit.Test;

import java.util.Iterator;

/**
 *  计算机学院, 测试
 * @author Jion
 */
public class ComputerCollegeTest {

    @Test
    public void test(){
        // 学院
        ComputerCollege college = new ComputerCollege();
        // 添加学系
        college.addDepartment("网络工程", "网络工程学系");
        college.addDepartment("软件工程", "软件工程学系");
        college.addDepartment("通信工程", "通信工程学系");

        // 迭代遍历
        Iterator<Department> iterator = college.iterator();
        while (iterator.hasNext()){
            Department next = iterator.next();
            System.out.println(next.getName()  + ": " + next.getDescription());
        }
    }
}