package commons.lang.mathDemo;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 	数字扩展
 * @author JionJion
 */
public class NumberExample {

	public static void main(String[] args) {
		
		/*
		 * 	判断字符串是否是数字
		 */
		NumberUtils.isCreatable("5.96");									//true
		NumberUtils.isCreatable("s5");										//false
		NumberUtils.isCreatable("0000000000596");							//true
		
		/*
		 *	判断是否可以转换
		 */
		NumberUtils.isParsable("");NumberUtils.isParsable(null);			//false
		NumberUtils.isParsable("a");										//false
		NumberUtils.isParsable("1");										//true
		
		/*
		 * 	判断字符串中是否全为数字
		 */
		NumberUtils.isDigits("0000000000.596");								//false
		NumberUtils.isDigits("0000000000596");								//true
		
		/*
		 * 	比较大小
		 * 	前者>后者:返回1
		 * 	前者=后者:返回0
		 * 	前者<后者:返回-1
		 */
		NumberUtils.compare(1, 0); 											//1比0大,返回1

		/*
		 * 	字符串转换为整数
		 * 	null,""将会转为0
		 * 	如果失败了或者为空,可以给默认值
		 */
		NumberUtils.toInt("5" , 0);
		NumberUtils.toLong("" , 1L);
		NumberUtils.toByte("3");
		NumberUtils.toFloat("3.2");
		NumberUtils.toDouble("4");
		NumberUtils.toShort("3");

		/*
		 * 	找出最大的一个
		 */
		NumberUtils.max(new int[]{3,5,6});									//6
		NumberUtils.max(3,1,7);												//7

		/*
		 * 	找出最小的一个
		 */
		NumberUtils.min(new int[]{3,5,6});									//6
		NumberUtils.min(3,1,7);												//7

		/*
		 * 	通过字符串创建BigDecimal类型，支持long、int、float、double、number等数值
		 */
		NumberUtils.createBigDecimal("1");
		NumberUtils.createLong("1");
		NumberUtils.createInteger("1");		
	}
}
