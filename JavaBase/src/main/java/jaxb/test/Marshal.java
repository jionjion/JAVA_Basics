package jaxb.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import jaxb.bean.BookListWrapper;
import jaxb.bean.Student;
import jaxb.bean.StudentListWrapper;

/**
 *	将JavaBean转为Xml
 *	在并发处理中,多将实例对象过程使用单例模式,作为类的静态属性
 */
public class Marshal {

	/**
	 * 	测试,将java对象转为xml文本
	 */
	@Test
	public void testMarshalObject() throws JAXBException{
		// 创建bean
		Student student = new Student();
		student.setName("Jion");
		student.setId(1);
		student.setAge(23.5D);
		student.setAddress("上海");
		student.setPostcode(1000L);
		// 日期
		Calendar birthday = Calendar.getInstance();
		birthday.set(2019, 0, 1);
		student.setBirthday(birthday);
		
		// 容器
		JAXBContext jaxbContext = JAXBContext.newInstance( Student.class );
		// 转换类
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// XML格式
		jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		// 控制台输出
		jaxbMarshaller.marshal( student, System.out );
		// 输出文件
		jaxbMarshaller.marshal( student, new File( "student.xml" ) );
		
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
	}
	
	/**
	 * 	测试,将java的list对象转为多组标签的xml文本
	 */
	@Test
	public void testMarshalObjectList() throws JAXBException {
		// 多个图书
		BookListWrapper books = new BookListWrapper();
		// 图书A
		BookListWrapper.book bookA = new BookListWrapper.book("Oralce指南","Jion",12.5);
		BookListWrapper.book bookB = new BookListWrapper.book("Vue入门","Arise",15.5);

		// 赋值list
		List<BookListWrapper.book> list = new ArrayList<BookListWrapper.book>();
		list.add(bookA);
		list.add(bookB);
		// 子节点
		books.setBookcase("计算机书架");
		books.setBooks(list);
		
		
		// 将ListObject 转为 XML
		// 容器
		JAXBContext jaxbContext = JAXBContext.newInstance( BookListWrapper.class );
		// 转换类
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// XML格式
		jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		// 控制台输出
		jaxbMarshaller.marshal( books, System.out );	
		/*
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<books>
			    <bookcase>计算机书架</bookcase>
			    <list>
			        <book>
			            <author>Jion</author>
			            <name>Oralce指南</name>
			            <price>12.5</price>
			        </book>
			        <book>
			            <author>Arise</author>
			            <name>Vue入门</name>
			            <price>15.5</price>
			        </book>
			    </list>
			</books>
		 */
	}
	
	/**
	 * 	测试,具有嵌套结构的javaBean转为xml
	 */
	@Test
	public void testMarshalNestList() throws JAXBException {
		// 创建bean
		Student studentA = new Student();
		studentA.setName("Jion");
		studentA.setId(1);
		studentA.setAge(23.5D);
		studentA.setAddress("上海");
		studentA.setPostcode(1000L);
		Calendar birthdayA = Calendar.getInstance();
		birthdayA.set(2019, 0, 1);
		studentA.setBirthday(birthdayA);
		// 创建bean
		Student studentB = new Student();
		studentB.setName("Arise");
		studentB.setId(2);
		studentB.setAge(18.0D);
		studentB.setAddress("上海");
		studentB.setPostcode(1200L);
		Calendar birthdayB = Calendar.getInstance();
		birthdayB.set(2000, 11, 31);
		studentB.setBirthday(birthdayB);
		
		// 赋值
		List<Student> list = new ArrayList<Student>();
		list.add(studentA);
		list.add(studentB);
		StudentListWrapper students = new StudentListWrapper();
		students.setList(list);
		
		
		// 将ListObject 转为 XML
		// 容器
		JAXBContext jaxbContext = JAXBContext.newInstance( StudentListWrapper.class );
		// 转换类
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// XML格式
		jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		// 控制台输出
		jaxbMarshaller.marshal( students, System.out );	
		
		/*
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<students xmlns:ns2="www.jionjion.top/java/example/bean/name" xmlns:ns3="www.jionjion.top/java/example/bean">
			    <student id="1">
			        <ns2:name>Jion</ns2:name>
			        <age>23.5</age>
			        <address>上海</address>
			        <postcode>1000</postcode>
			        <birthday>2019-01-01</birthday>
			    </student>
			    <student id="2">
			        <ns2:name>Arise</ns2:name>
			        <age>18.0</age>
			        <address>上海</address>
			        <postcode>1200</postcode>
			        <birthday>2000-12-31</birthday>
			    </student>
			</students>
		 */
	}

}
