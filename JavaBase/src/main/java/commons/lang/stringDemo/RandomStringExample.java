package commons.lang.stringDemo;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 	随机字符串
 * @author JionJion
 */
public class RandomStringExample {

	public static void main(String[] args) {
		/*
		 * 	产生5位长度的随机字符串，中文环境下是乱码
		 * 	好像没什么要你管
		 */
		RandomStringUtils.random(5);


		/*
		 * 	使用指定的字符生成5位长度的随机字符串
		 */
		RandomStringUtils.random(5, new char[]{'a','b','c','d','e','f', '1', '2', '3'});


		/*
		 * 	生成指定长度的字母和数字的5位随机组合字符串
		 */
		RandomStringUtils.randomAlphanumeric(5);


		/*
		 * 	生成随机5位数字字符串
		 */
		RandomStringUtils.randomNumeric(5);


		/*
		 * 	生成[a-z]随机5位字符串，包含大小写
		 */
		RandomStringUtils.randomAlphabetic(5);


		/*
		 * 	生成从ASCII 32到126组成的随机5位字符串,基本涵盖常见字符
		 */
		RandomStringUtils.randomAscii(4);
	}
}
