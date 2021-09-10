package commons.io.utilityTool;


import org.apache.commons.io.IOCase;

/**
 *	IOCase: 字符串操作和比较方法。
 *	IOCase.SENSITIVE    大小写敏感
 *	IOCase.INSENSITIVE	大小写不敏感
 *	IOCase.SYSTEM		对于window系统和Linux系统使用
 */
public class IOCaseExample {

	public static void main(String[] args) {
		
		String str1 = "hello world";
		String str2 = "Hello World";
		
		
		/*
		 * 	SENSITIVE 枚举方法的使用,该枚举成员,严格区大小写
		 */
		//获得枚举对象
		IOCase sensitive = IOCase.forName(IOCase.SENSITIVE.getName());
		
		//比较差异,0相等
		System.out.println("字符串差异:" + sensitive.checkCompareTo(str1, str2));
		
		//比较是否相等
		System.out.println("是否相等:" + sensitive.checkEquals(str1, str2));
		
		//是否以XX开始
		System.out.println("是否以H开始:" + sensitive.checkStartsWith(str2, "H"));
		
		//是否以XX结尾
		System.out.println("是否以d结尾:" + sensitive.checkEndsWith(str1, "d"));
		
		//从前往后,查找指定字符第一次出现的位置,位置从0开始,没有找到返回-1
		System.out.println("o的首次出现的位置:" + sensitive.checkIndexOf(str1, 0, "o"));
		
		//指定位置是否为指定字符串
		System.out.println("" + sensitive.checkRegionMatches(str1, 0, "h"));
	}
}
