package commons.io.filefilterDemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public final class FiltersExample {
    
	public static void main(String[] args) {

		
		//目录
		String direStr = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\";
		
		//目录对象
		File dire = FileUtils.getFile(direStr);
		
		/*
		 * 	NameFileFilter 文件名过滤器
		 * 	指定接收的文件名字,大小写不敏感
		 * 	格式:文件名.文档格式
		 */
        String[] acceptedNames = {"fileA", "fileB.txt"};
        for (String file: dire.list(new NameFileFilter(acceptedNames, IOCase.INSENSITIVE))) {
            System.out.println("使用文件名过滤器:" + file);
        }
        
        
        /*
         * 	WildcardFileFilter 通配符过滤器
         * 	? 匹配一个或没有字符
         * 	* 匹配任意个字符
         */
        for (String file: dire.list(new WildcardFileFilter("*file*"))) {
            System.out.println("使用通配符过滤器:" + file);
        }
        
        
        /*
         *  PrefixFileFilter 前缀过滤器
         */
        for (String file: dire.list(new PrefixFileFilter("file"))) {
            System.out.println("使用前缀过滤器:" + file);
        }
        
        
        /*
         *  SuffixFileFilter 后缀过滤器
         */
        for (String file: dire.list(new SuffixFileFilter(".txt"))) {
            System.out.println("使用后缀过滤器:" + file);
        }
        
        
        /*
         *  OrFileFilter 逻辑或过滤器 
         *  通过传入多个过滤器条件进行组装
         */
        for (String file: dire.list(new OrFileFilter(
                new WildcardFileFilter("*file*"), new SuffixFileFilter(".txt")))) {
            System.out.println("使用逻辑或过滤器 :" + file);
        }
        
        /*
         * 	AndFileFilter 逻辑与过滤器
         * 	NotFileFilter 逻辑非过滤器
         * 	通过传入多个逻辑过滤器进行嵌套
         */
        for (String file: dire.list(new AndFileFilter( 
                new WildcardFileFilter("*file*"), 
                	new NotFileFilter(new SuffixFileFilter(".doc"))))) {
            System.out.println("复杂逻辑过滤器:" + file);
        }
    }
}