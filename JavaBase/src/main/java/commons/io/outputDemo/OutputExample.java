package commons.io.outputDemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;


/**
 *	可以将输入流发送到2个不同的输出
 */
public class OutputExample {

	public static void main(String[] args) throws Exception{
		//输入字符串
		String inputStr = "哔哩哔哩...";
	        
		//获得字符串
        InputStream in = new ByteArrayInputStream(inputStr.getBytes("UTF-8"));
        //两个输出流
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        
        //创建两个输出流
        TeeOutputStream teeOut = new TeeOutputStream(out1, out2);
        //进行输出流到两个输出流的拷贝
        TeeInputStream teeIn = new TeeInputStream(in, teeOut, true);
        teeIn.read(new byte[inputStr.getBytes().length]);
        
        //获得输出流
        System.out.println("拷贝输出流:" + out1.toString("UTF-8"));
        System.out.println("拷贝输出流:" + out2.toString("UTF-8"));
        
        //关闭流
        teeIn.close();
	}
}
