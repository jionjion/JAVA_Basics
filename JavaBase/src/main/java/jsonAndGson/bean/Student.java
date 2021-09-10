package jsonAndGson.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**对应的javaBean*/
public class Student {

	@SerializedName("NAME")					//GSON所特有的类,强制属性名大写
	private String name;
	private double age;
	@SerializedName("BIRTHDAY")
	private Date birthday;
	private transient String school;		//transient.不会被转换为JSON属性
	private String[] major;
	private boolean single;
	private String car;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String[] getMajor() {
		return major;
	}
	public void setMajor(String[] major) {
		this.major = major;
	}
	public boolean isSingle() {
		return single;
	}
	public void setSingle(boolean single) {
		this.single = single;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	
}
