package commons.io.inputDemo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.TeeInputStream;

/**
 *	自动将读取的字节从输入复制到输出
 */
public class InputExample {

	public static void main(String[] args) throws Exception{
		        
		//输入字符串
		String inputStr = "哔哩哔哩...";
		
		//文件路径
		String filename = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\fileA.txt";
		
		//文件对象
		File file = FileUtils.getFile(filename);
		
		//将字符转为输入流
        InputStream in = new ByteArrayInputStream(inputStr.getBytes("UTF-8"));
        //将将输出流追加入文件
        OutputStream out = new FileOutputStream(file,true);

        //传入输入流,输出流,是否自动关闭
        TeeInputStream tee = new TeeInputStream(in, out, true);

        //使用字节数组进行读取,一次读取完毕
        tee.read(new byte[inputStr.getBytes().length]);
        
        //关闭流
        tee.close();
	}
}
