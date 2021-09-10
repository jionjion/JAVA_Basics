package jsonAndGson.gson;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jsonAndGson.bean.Student;

/**
 * 	生成GSON的类*/
public class MakeGSONObject {

	/**使用javaBean创建GSON*/
	public static void createGSONObjectByJavaBean() throws Exception {
		Student student = new Student();
		student.setName("张谦");
		student.setAge(24.2);
		student.setBirthday(new SimpleDateFormat("YYYY-MM-DD").parse("1994-04-12"));	//日期转换
		student.setSchool("河南科技学院");
		student.setSingle(false);
		student.setCar(null);
		//创建GSON对象
//		Gson gson = new Gson();	//使用直接new的方式创建
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();	//
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {	//
			//
			@Override
			public String translateName(Field field) {		//field,表示属性名
				if (field.getName().equals("age")) {		//表示属性名是否相等
					return "age是:";
				}
				return field.getName();
			}
		});
		Gson gson = gsonBuilder.create();	//创建JSON对象
		System.out.println("GSON开始:");
		System.out.println(gson.toJson(student));
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) throws Exception{
		createGSONObjectByJavaBean();
	}
}
