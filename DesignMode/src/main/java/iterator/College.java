package iterator;

import java.util.Iterator;

/**
 * 学院类, 接口定义规范
 *
 * @author Jion
 */
public interface College {

    /**
     * 获得学院描述
     *
     * @return 学院
     */
    String getName();

    /**
     * 增加学院系名
     *
     * @param name        学院名
     * @param description 对应学院系名
     */
    void addDepartment(String name, String description);

    /**
     * 返回迭代器,遍历
     *
     * @return 学院
     */
    Iterator<Department> iterator();
}
