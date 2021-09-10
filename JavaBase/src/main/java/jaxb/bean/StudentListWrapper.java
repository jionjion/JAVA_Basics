package jaxb.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 	具有嵌套关系的javaBean相互转换
 */

@XmlRootElement(name = "students")
public class StudentListWrapper {
	
	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	// 指明具体的类型
	@XmlElement(name="student",type=Student.class)
	public void setList(List<Student> list) {
		this.list = list;
	}
	
}