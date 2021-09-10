package commons.io.comparatorDemo;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;

/**
 *	轻松地比较和排序文件和目录
 */
public class ComparatorExample {

	public static void main(String[] args) {
        
		
		//目录
		String direStr = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\";
		
		//目录对象
		File dire = FileUtils.getFile(direStr);		
		
        /*
         * 	NameFileComparator 文件名比较器
         * 	根据文件名进行排序,大小写敏感
         */
        
		//创建比较器根据文档名,大小写敏感进行排序,由A到Z
        NameFileComparator comparator = new NameFileComparator(IOCase.SENSITIVE);
        //对多个文件进行排序,传入和返回均为File[]数组
        File[] sortedFiles = comparator.sort(dire.listFiles());
        
        for (File file: sortedFiles) {
            System.out.println("使用文件名进行排序:" + "\t"+ file.getAbsolutePath());
        }
        
        
        /*
         * 	SizeFileComparator 文件大小比较器,由小到大
         * 	true:目录内的文件也算大小
         * 	false:目录大小为0
         */
        SizeFileComparator sizeComparator = new SizeFileComparator(true);
        File[] sizeFiles = sizeComparator.sort(dire.listFiles());
        
        for (File file: sizeFiles) {
            System.out.println("使用文件大小比较器" + "\t"+ file.getName()  + file.length() + "kb");
        }
        
        
        /*
         *	LastModifiedFileComparator 最后修改时间比较器,由远及近
         */
        LastModifiedFileComparator lastModified = new LastModifiedFileComparator();
        File[] lastModifiedFiles = lastModified.sort(dire.listFiles());
        
        for (File file: lastModifiedFiles) {
            Date modified = new Date(file.lastModified());
            System.out.println("使用最后修改时间比较器:" + "\t"+ file.getName() + "最后修改时间:" + modified);
        }
    }
}
