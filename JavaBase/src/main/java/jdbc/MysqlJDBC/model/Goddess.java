package jdbc.MysqlJDBC.model;

import java.util.Date;

/**对应数据库中的女神表*/
public class Goddess {

	private int id;
	private String userName;
	private String sex;
	private int age;
	private Date birthday;
	private String email;
	private String mobile;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private int isDel;
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Goddess(int id, String userName, String sex, int age, Date birthday, String email, String mobile,
			String createUser, Date createDate, String updateUser, Date updateDate, int isDel) {
		super();
		this.id = id;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.email = email;
		this.mobile = mobile;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.isDel = isDel;
	}
	public Goddess() {
		super();
	}
	@Override
	public String toString() {
		return "Goddess [id=" + id + ", userName=" + userName + ", sex=" + sex + ", age=" + age + ", birthday="
				+ birthday + ", email=" + email + ", mobile=" + mobile + ", createUser=" + createUser + ", createDate="
				+ createDate + ", updateUser=" + updateUser + ", updateDate=" + updateDate + ", isDel=" + isDel + "]";
	}
	
}
