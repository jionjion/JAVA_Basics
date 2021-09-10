package fileReadOrWrite.BufferedReaderOrWriteOrPrintType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**对文件进行整行的读取*/
public class BufferedReaderOrWriteOrPrintDemol{

	public static void main(String[] args) throws Exception{
		//对文件进行读写
		BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\BufferedReaderOrWriteOrPrintType\\BRA")));
		
		//使用BufferedWriter进行拷贝生成的文件
		BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\BufferedReaderOrWriteOrPrintType\\BRB")));
		
		//使用PrintWriter进行拷贝生成的文件
		PrintWriter printWriter = new PrintWriter("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\BufferedReaderOrWriteOrPrintType\\BRC"); 
		
		String line;
		while((line = bufferedReader.readLine()) != null){
			System.out.print(line);			//bufferedReader对象不能识别换行符
			bufferedWriter.write(line);
			bufferedWriter.newLine();		//因此在BufferedWriter需要主动换行
			
			printWriter.println(line);		//而printWriter进行
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		printWriter.flush();
		printWriter.close();
		bufferedReader.close();
		
		
	}
}
