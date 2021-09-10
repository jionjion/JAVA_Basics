package jsonAndGson.json;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**解析JSON文件*/
public class ParseJSONObject {

	/**ʹ解析JSON文件*/
	public static void parseJSONObjectByFile() throws Exception{
		File file = new File("F:\\JAVA_WorkSpace\\JSON\\src\\json\\JSON对象.json");	//传入文件
		//将文件转为String
		String content = FileUtils.readFileToString(file,"utf8");
		//解析为JSON对象
		JSONObject jsonObject = JSONObject.fromObject(content);
		//获得JSON对象的属性
		String name = jsonObject.getString("name");
		System.out.println("姓名:"+name);
		float age = (float) jsonObject.getDouble("age");
		System.out.println("年龄:"+age);
		Date birthday = new SimpleDateFormat("YYYY-MM-DD").parse(jsonObject.getString("birthday"));
		System.out.println("生日:"+birthday);
		String school = jsonObject.getString("school");
		System.out.println("学校:"+school);
		JSONArray jsonArray = jsonObject.getJSONArray("major");
		for (Object object : jsonArray) {
			System.out.println("专业:"+object.toString());
		}
		boolean single = jsonObject.getBoolean("single");
		System.out.println("单身:"+single);
	}
	
	public static void main(String[] args) throws Exception{
		parseJSONObjectByFile();
	}
}
