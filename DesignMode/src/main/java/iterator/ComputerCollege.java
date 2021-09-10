package iterator;

import java.util.Iterator;

/**
 *  计算机学院, 具体的学院.
 * @author Jion
 */
public class ComputerCollege implements College{

    /** 聚合,一个数组. */
    Department[] departments;

    /** 保存当前数据组,对象个数 */
    int countOfDepartment = 0;

    public ComputerCollege(){
        departments = new Department[8];
    }

    @Override
    public String getName() {

        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        departments[countOfDepartment] = department;
        countOfDepartment++;
    }

    /** 获得迭代器,自定义的迭代器 */
    @Override
    public Iterator<Department> iterator() {
        return new CollegeArrayIterator(departments);
    }
}
