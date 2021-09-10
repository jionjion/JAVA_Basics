package regExregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
public class Mate {

	/**
	 *	使用正则完成基本的字符匹配
	 */
	@Test
	public void mateMode() {
		//准备要匹配的字符串
		String content = "I am mode , thinks !";
		//正则表达式
		String pattern = ".*mode.*";		//匹配前后任何字符,包含mode关键字
		//调用Pattern的静态方法,传入正则表达式和文本内容,是否匹配
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("字符串中是否包含了 'mode' 子字符串? " + isMatch);
	}
	
	
	/**
	 * 	使用正则完成字符串的匹配截取
	 */
	@Test
	public void findMode() {
		//按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		
		//分为三部分,第一个部分匹配非数字开头的,第二部分匹配数字部分,第三部分匹配任意字符开头的部分
		String reg = "(\\D*)(\\d+)(.*)";		
	 
	    //传入正则表达式,创建 Pattern 对象
	    Pattern pattern = Pattern.compile(reg);
	 
	    //Pattern对象传入要匹配的字符,创建 matcher 对象
	    Matcher matcher = pattern.matcher(line);
	    //进行匹配查询,并返回布尔值,表示是否匹配到
	    if (matcher.find()) {		
	    	System.out.println("group(0)表示全部: " + matcher.group(0) );
	    	System.out.println("group(1): " + matcher.group(1) );
	    	System.out.println("group(2): " + matcher.group(2) );
	    	System.out.println("group(3): " + matcher.group(3) ); 
	    } else {
	    	System.out.println("没有匹配");
	    }
	}
	
	
	@Test
	public void countMode() {

		//正则表达式.匹配字符边界..一共四个cat
		String regex = "\\bcat\\b";
		
		//要匹配的字符串
		String line = "cat cat cat cattie cat";
		
		//将正则表达式传入,创建Pattern对象
		Pattern pattern = Pattern.compile(regex);
		
		//获取 matcher 对象
		Matcher matcher = pattern.matcher(line);
		
		int count = 0;
		
		//进行匹配,返回匹配结果.默认返回当前指针,最近匹配的一个
		while (matcher.find()) {
			count++;
			System.out.println("匹配序数:" + count);
			System.out.println("开始位置: " + matcher.start());
			System.out.println("结束位置: " + matcher.end());
		}
	}
	
	/**
	 * 	matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matcher 要求整个序列都匹配，而lookingAt 不要求。
	 *	lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
	 */
	@Test
	public void matchesAndLookingAt() {

		//创建正则
		String regex = "foo";
		//要匹配的字符串
		String input1 = "fooooooooooooooooo";
		String input2 = "ooooofoooooooooooo";

		//传入正则表达式,创建Pattern对象
		Pattern pattern = Pattern.compile(regex);
		//分别传入,完成解析
		Matcher matcher1 = pattern.matcher(input1);
		Matcher matcher2 = pattern.matcher(input2);
		//
		System.out.println("在字符串中,全部搜索: " + matcher2.matches());
		System.out.println("尽在开头查询: " + matcher1.lookingAt());
		System.out.println("尽在开头查询: " + matcher2.lookingAt());
	}
	
	
	@Test
	public void ReplaceFirstAndReplaceAll() {

		//正则表达式,表示匹配dog关键字
		String regex = "dog";

		//要匹配的字符串
		String input = "The dog says miao, All dogs and other dog say miao~";
		//将要替换的字符串
		String replace = "cat";
		
		//传入正则表达式,创建Pattern对象
		Pattern pattern = Pattern.compile(regex);
		//创建matcher对象
		Matcher matcher = pattern.matcher(input);
		//执行,替换一个,返回替换结果
		String output = matcher.replaceFirst(replace);
		System.out.println(output);
		//执行,全部替换,返回替换结果
		output = matcher.replaceAll(replace);
		System.out.println(output);
	}
	
	@Test
	public void appendReplacementAndAppendTail() {

		//声明正则表达式. 匹配,a可以有任意多个,b只有一个
		String regex = "a*b";
		
		//定义输入字符串
		String input = "aabfooaabfooabfoobccc";
		//替换字符串
		String replace = "-";
		//将正则表达式传入,创建Patter对象
		Pattern pattern = Pattern.compile(regex);
		//创建matcher对象
		Matcher matcher = pattern.matcher(input);
		
		StringBuffer stringBuffer = new StringBuffer();
		while (matcher.find()) {
			//将匹配的完成替换
			matcher.appendReplacement(stringBuffer, replace);
		}
		//将最后剩余的ccc进行追加
		matcher.appendTail(stringBuffer);		
		System.out.println(stringBuffer.toString());
	}
	
}
