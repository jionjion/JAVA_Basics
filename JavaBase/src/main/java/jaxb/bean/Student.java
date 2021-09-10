package jaxb.bean;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 	正常的Java对象,将其转为XML 该过程被称为marshal
 */

// XmlType标识该XML的属性.namespace表示命名空间;propOrder指定生成的xml对象的标签顺序
@XmlType(namespace = "https://www.w3.org/2001/XMLSchema", propOrder = { "name", "age", "address", "postcode", "birthday" })
// XmlRootElement标识这是一个xml的根标签,name指明标签的名字,缺省为类名.namespace:指明该标签的命名空间
@XmlRootElement(name = "student", namespace = "www.jionjion.top/java/example/bean")
public class Student {
	
	private Integer id;
	// 标识这是一个属性,并为必输,属性标注在根节点中
	@XmlAttribute(name="id", required=true)
	public void setId(Integer id) {
		this.id = id;
	}

	private String name;
	// 在私有属性中,@XmlElement注解仅在get()/set()方法使用,如果为共有属性,则不做限制
	//标识这是一个标签元素,可以指定标签级别的,且为必输
	@XmlElement(name = "name", namespace = "www.jionjion.top/java/example/bean/name", required=true)
	public void setName(String name) {
		this.name = name;
	}

	private Double age;
	@XmlElement(name = "age")
	public void setAge(Double age) {
		this.age = age;
	}
	
	private String address;
	@XmlElement(name = "address")
	public void setAddress(String address) {
		this.address = address;
	}

	private Long postcode;
	// 标识这是一个属性,并为必输
	@XmlElement(name = "postcode")
	public void setPostcode(Long postcode) {
		this.postcode = postcode;
	}

	private Calendar birthday;
	
	@XmlElement(name = "birthday")
	// 适配器,限定转换格式
	@XmlJavaTypeAdapter( DateAdapter.class )
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	public Double getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public Long getPostcode() {
		return postcode;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", postcode="
				+ postcode + ", birthday=" + birthday + "]";
	}
}
