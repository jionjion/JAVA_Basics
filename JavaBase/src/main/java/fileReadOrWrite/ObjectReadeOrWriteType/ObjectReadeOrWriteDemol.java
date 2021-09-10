package fileReadOrWrite.ObjectReadeOrWriteType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**对对象实现序列化*/
public class ObjectReadeOrWriteDemol {

	public static void main(String[] args) throws Exception{
		String file = "F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\ObjectReadeOrWriteType\\student";
		//对象的序列化 
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
								new FileOutputStream(file));
		//创建对象
		Student student = new Student(1,"张谦");
		//保存对象
		objectOutputStream.writeObject(student);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		//反序列化
		ObjectInputStream objectInputStream = new ObjectInputStream(
								new FileInputStream(file));
		Student newStudent = (Student) objectInputStream.readObject();
		System.out.println(newStudent.toString());
		objectInputStream.close();
	}
}
