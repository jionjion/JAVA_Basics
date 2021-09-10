package jaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import jaxb.bean.Student;

/**
 *	将Xml转为javabean
 *	在并发处理中,多将实例对象过程使用单例模式,作为类的静态属性
 */
public class UnMarshal {

	/**
	 * 	测试,将java对象转为xml文本
	 */
	@Test
	public void testUnMarshalObject() throws JAXBException{
	/*
	  	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<ns3:student xmlns:ns2="www.jionjion.top/java/example/bean/name" xmlns:ns3="www.jionjion.top/java/example/bean" id="1">
		    <ns2:name>Jion</ns2:name>
		    <age>23.5</age>
		    <address>上海</address>
		    <postcode>1000</postcode>
		    <birthday>2019-01-01</birthday>
		</ns3:student>
	 */		
		// 文件
		File file = new File( "student.xml" );
		JAXBContext jaxbContext = JAXBContext.newInstance( Student.class );
		// 转换
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Student student = (Student)jaxbUnmarshaller.unmarshal( file );
		System.out.println( student );
	}
}