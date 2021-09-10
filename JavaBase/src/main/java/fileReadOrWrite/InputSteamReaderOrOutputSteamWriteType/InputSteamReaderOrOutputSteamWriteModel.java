package fileReadOrWrite.InputSteamReaderOrOutputSteamWriteType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**字符输入流和字符输出流*/
public class InputSteamReaderOrOutputSteamWriteModel {

	public static void main(String[] args) throws Exception{
		FileInputStream fileInputStream = new FileInputStream("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputSteamReaderOrOutputSteamWriteType\\RA");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");			//默认使用项目编码格式
		int p;	//读到的是一个char,包装为int类型
		while( (p=inputStreamReader.read()) != -1 ){
			System.out.print((char)p);
		}
		
		/*默认只能读取一次*/
		FileOutputStream fileOutputStream = new FileOutputStream("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputSteamReaderOrOutputSteamWriteType\\RB");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
		char[] buffer = new char[8*1024];	//默认的为char型,这里使用char数组
		int c;
		//批量读取,放入buffer字符数组,从第0个位置开始放置,最多放入buffer的长度,返回的是读到的个数
		while( (c=inputStreamReader.read(buffer, 0, buffer.length)) != -1 ){
			//读取文件,到字符串中
			String string = new String(buffer, 0, c);
			System.out.println(string);
			//写入文件
			outputStreamWriter.write(buffer,0,c);
			outputStreamWriter.flush();
		}
		
		inputStreamReader.close();
		outputStreamWriter.close();
		
	}
}
