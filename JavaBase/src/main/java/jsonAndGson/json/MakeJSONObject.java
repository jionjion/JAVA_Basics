package jsonAndGson.json;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import jsonAndGson.bean.Student;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**创建JSON对象*/
public class MakeJSONObject {
	/* 
   {
	"name" 	: 	"张谦",
	"age"	:	24.2,
	"birthday":	"1994-4-12",
	"school":	"河南科技学院",
	"major"	:	["机械设计","电子工程","软件工程"],
	"single":	false,
	"car"	:	null
	}
	 */
	/**直接创建JSON对象*/
	public static void createJSONObjectByJSONObject() throws JSONException{
		JSONObject jsonObject = new JSONObject();
		Object nullObject = null;	//创建空对象,表示null本身
		jsonObject.put("name", "张谦");
		jsonObject.put("age", 24.2);
		jsonObject.put("birthday", "1994-4-12");
		jsonObject.put("school", "河南科技学院");
		jsonObject.put("marjor", new String[]{"机械设计","电子工程","软件工程"});
		jsonObject.put("single", false);
		jsonObject.put("car", nullObject);	//传入空对象
		//输出
		System.out.println("JSON解析:");
		System.out.println(jsonObject.toString());
		System.out.println("-------------------");
		
	}
	
	/**通过Map创建JSON对象*/
	public static void createJSONObjectByMap() throws JSONException{
		Map<String, Object> map = new HashMap<String, Object>();
		Object nullObject = null;	//创建空对象
		map.put("name", "张谦");
		map.put("age", 24.2);
		map.put("birthday", "1994-4-12");
		map.put("school", "河南科技学院");
		map.put("major", new String[]{"机械设计","电子工程","软件工程"});
		map.put("single", false);
		map.put("car", nullObject);	//传入空对象
		//将Map解析为JSON对象
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		//输出
		System.out.println("JSON解析:");
		System.out.println(jsonObject.toString());
		System.out.println("-------------------");
	}
	
	/**将javaBean解析JSON*/
	public static void createJSONObjectByJavaBean() throws Exception {
		Student student = new Student();
		student.setName("张谦");
		student.setAge(24.2);
		student.setBirthday(new SimpleDateFormat("YYYY-MM-DD").parse("1994-04-12"));	
		student.setSchool("河南科技学院");
		student.setSingle(false);
		student.setCar(null);
		//将JavaBean解析为JSON对象
		JSONObject jsonObject = JSONObject.fromObject(student);		//对日期支持不好	
		System.out.println("JSON解析:");
		System.out.println(jsonObject.toString());
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) throws Exception {
		createJSONObjectByJSONObject();
		createJSONObjectByMap();
		createJSONObjectByJavaBean();
	}
}

