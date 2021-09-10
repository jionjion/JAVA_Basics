package networkCommunication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;

import com.mysql.jdbc.Buffer;

/**URL类*/
public class URLDemo {

	public static void main(String[] args) throws Exception{
		
		//创建一个URL实例
		URL baidu = new URL("http://www.baidu.com");
		//创建子URL
		URL url = new URL(baidu,"/s?wd=hello#index");
		
		System.out.println("协议类型:"+url.getProtocol());
		System.out.println("主机IP:"+url.getHost());
		System.out.println("端口号:"+url.getPort());
		System.out.println("文件的路径:"+url.getPath());
		System.out.println("文件名:"+url.getFile());
		System.out.println("相对路径:"+url.getRef());
		System.out.println("查询字符串:"+url.getQuery());
		
		//查询网页
		InputStream inputStream = url.openStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		//读取数据
		String data = bufferedReader.readLine();
		while(data != null){
			System.out.println(data);
			data = bufferedReader.readLine();
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
	}
}
