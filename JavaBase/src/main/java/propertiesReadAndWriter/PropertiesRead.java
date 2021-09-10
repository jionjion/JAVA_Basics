package propertiesReadAndWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**属性文件的读取*/
public class PropertiesRead {

	/**读取配置文件,返回map集合*/
	public static Map<String, String> read(File file) throws Exception{
		
		Map<String, String> map = new HashMap<String,String>();
		//获取输入流
		InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
		//创建属性文件对象
		Properties properties = new Properties();
		//传入输入流
		properties.load(inputStream);
		//读取配置文件的key们
		Enumeration<?> enumeration = properties.propertyNames();
		//变量key们,获取每个对象
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			//得到键对应的值
			String value = (String) properties.getProperty(key);
			map.put(key, value);
		}
		inputStream.close();
		return map;
	}
	
	/**写入配置文件,写入Map集合,存在相同键则更新,否则为新增*/
	public static void writer(Map<String, String> map , File file) throws Exception{
		//获取输出流
		OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(file,false), StandardCharsets.UTF_8);
		//创建属性文件对象
		Properties properties = new Properties();
		
		//遍历更新
		for(Map.Entry<String, String> entry : map.entrySet()) {
			properties.setProperty(entry.getKey(), entry.getValue());
			System.out.println("写入>>键:" + entry.getKey() + "   值:"
					+ entry.getValue());			
		} 
		
		//输出文件
		properties.store(outputStream, "this is comments");
		outputStream.close();
		
	}
	
	
	public static void main(String[] args) throws Exception{
		File file = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\propertiesReadAndWriter\\student.properties");
		
		//写入操作
		Map<String, String> writerMap = new HashMap<>();
		writerMap.put("six", "男");
		writerMap.put("name", "Jion");
		writerMap.put("age", "23.4");
		writerMap.put("birthday", "1994-04-12");
		writer(writerMap, file);
		

		//读取操作
		Map<String, String> readMap = read(file);
		//遍历map
		for (Map.Entry<String, String> entry : readMap.entrySet()) {
			//Map.entry<String,String> 映射项（键-值对）  有几个方法：用上面的名字entry
			//entry.getKey();键的查询
			//entry.getValue(); entry.setValue();值的查询/修改	
			//map.entrySet()  返回此映射中包含的映射关系的 Set视图。
			System.out.println("读取>>键:" + entry.getKey() + "   值:"
						+ entry.getValue());
	    }
	}
}
