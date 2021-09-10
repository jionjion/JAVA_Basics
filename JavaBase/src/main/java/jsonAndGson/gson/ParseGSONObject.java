package jsonAndGson.gson;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jsonAndGson.bean.Student;


/**将文件解析为GSON对象*/
public class ParseGSONObject {

	/**通过文件解析*/
	public static void parseGSONObjectByFile() throws Exception{
		File file = new File("F:\\JAVA_WorkSpace\\JSON\\src\\json\\GSON对象.gson");	//文件的地址
		//将文件转为String
		String content = FileUtils.readFileToString(file,"utf8");
		//设置日期格式
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();	//日期格式
		//设置传入的文件,并转为的JavaBean
		Student student = gson.fromJson(content, Student.class);
		System.out.println("姓名:"+student.getName());
		System.out.println("年龄:"+student.getAge());					//需要大小写一致,并在JavaBean中声明的
		System.out.println("生日:"+student.getBirthday());
		System.out.println("学校:"+student.getSchool());
		System.out.println("专业:"+student.getMajor());
		System.out.println("单身:"+student.isSingle());
		
	}
	
	public static void main(String[] args) throws Exception{
		parseGSONObjectByFile();
	}
}
