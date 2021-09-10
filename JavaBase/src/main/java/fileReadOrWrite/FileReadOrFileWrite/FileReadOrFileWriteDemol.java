package fileReadOrWrite.FileReadOrFileWrite;
import java.io.FileReader;
import java.io.FileWriter;
/**文件读入,不能指定编码格式*/
public class FileReadOrFileWriteDemol {

	public static void main(String[] args) throws Exception{
		FileReader fileReader = new FileReader("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\fileReadOrfilewrite\\FRA");
		FileWriter fileWriter = new FileWriter("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\fileReadOrfilewrite\\FRB",true);	//表示对文件追加
		char[] buffer = new char[2*1024];
		int p;
		while((p=fileReader.read(buffer)) != -1){
			fileWriter.write(buffer, 0, p);
		}
		fileWriter.flush();
		fileWriter.close();
		fileReader.close();
	}
}
