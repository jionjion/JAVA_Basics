package fileReadOrWrite.ObjectReadeOrWriteType;

import java.io.IOException;
import java.io.Serializable;

/**学生类,实现序列化接口*/
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	
	private transient String  name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	private void writeObject(java.io.ObjectOutputStream stream) 
						throws IOException, ClassNotFoundException{
		//将虚拟机默认序列化的元素进行序列化操作
		stream.defaultWriteObject();
		//自定义完成序列化
		stream.writeUTF(name);
	}
	private void readObject(java.io.ObjectInputStream stream) 
			throws IOException, ClassNotFoundException{
	//将虚拟机默认序列化的元素进行反序列化操作
	stream.defaultReadObject();
	//自定义完成序列化
	this.name =  stream.readUTF();
	}
	
}
