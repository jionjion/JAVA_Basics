package iterator;

import java.util.Iterator;

/**
 *  学院迭代器, 迭代内部的学系
 *  内部为数组
 * @author Jion
 */
public class CollegeArrayIterator implements Iterator<Department> {

    /** 迭代的对象 */
    private final Department[] departments;

    /** 遍历的位置 */
    private int position = 0;

    public CollegeArrayIterator(Department[] departments){
        this.departments = departments;
    }

    /** 数组是否含有下一个 */
    @Override
    public boolean hasNext() {
        return position < departments.length && departments[position] != null;
    }

    /** 遍历下一个 */
    @Override
    public Department next() {
        Department department = departments[position];
        position++;
        return department;
    }

    /** 删除方法.不作处理 */
    @Override
    public void remove() {

    }
}
