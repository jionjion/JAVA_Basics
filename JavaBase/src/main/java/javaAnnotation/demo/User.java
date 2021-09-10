package javaAnnotation.demo;
/**自定义的User表,解析注解生成该对象*/

@Table("user")						//自定义注解,表名
public class User {

	@Column("id")					//自定义注解,字段名
	private int id;					//私有属性中保存的值,为查询条件的值

	@Column("user_name")
	private String username;

	@Column("nick_name")
	private String nickName;

	@Column("age")
	private int age;

	@Column("email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}  
}
