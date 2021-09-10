package commons.lang.reflectDemo;
/**
 *	反射调用的类 	
 */

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class Student {

	/** 共有属性,学生ID */
	public Long id;
	
	/** 共有属性,学生姓名 */
	public String name;
	
	/** 私有属性,学生生日 */
	private Date birthday;
	
	public static String hashCode = "STUDENT";
	
	public Student() {
		super();
	}
	
	public Student(Long id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	
	/** 静态方法 */
	public static void staticSay() {
		System.out.println("我是学生!");
	}
	
	/** 无参数的共有方法 */
	public void sayName() {
		System.out.println("我是学生:" + name);
	}
	
	/** 有参数的共有方法 */
	public void sayBirthday(Date birthday) {
		System.out.println("我的生日是:" + DateFormatUtils.format(birthday, "yyyy-MM-dd"));
	}
	
	/** 由参数携带返回值的方法 */
	public String sayIntroduce(int id) {
		String name = getName();
		String birthday = DateFormatUtils.format(getBirthday(), "yyyy-MM-dd");
		return "Student's is" + id + ",he name is" + name + ",bithday is " + birthday + ".";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	


	
	
}
