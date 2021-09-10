package xmlReadAndWriter.xmlWriter.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**	使用Dom方式生成XML文件*/
public class WriteXmlByDom {

	public static void main(String[] args) throws Exception{
		//引入文件
		File xml = new File("src/xmlReadAndWriter/xmlWrite/Books.xml");
		
		//创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		//创建一个DocumentBuilder对象
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		//生成XML文件,创建Document对象
		Document document = documentBuilder.newDocument();
		document.setXmlStandalone(true);	//设置standalone为yes,不显示
		document.setXmlVersion("1.0");		//设置版本
		//创建节点,并添加到文件中,第一个节点为根节点
		Element bookStrore = document.createElement("bookstore");
		document.appendChild(bookStrore);
		//创建子节点,设置属性,并添加到父节点中.
		Element book = document.createElement("book");
		book.setAttribute("id", "1");
		bookStrore.appendChild(book);
		//为子节点设置带文本的子节点
		Element name = document.createElement("name");
		name.setTextContent("冰与火之歌");
		book.appendChild(name);
		Element author = document.createElement("author");
		author.setTextContent("乔治马丁");
		book.appendChild(author);
		Element year = document.createElement("year");
		year.setTextContent("2014");
		book.appendChild(year);
		Element price = document.createElement("price");
		price.setTextContent("98$");
		book.appendChild(price);
		
		//创建转换工厂,设置格式,进行输出
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");	//字符编码
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");		//是否换行
		transformer.transform(new DOMSource(document), new StreamResult(xml));
	}
}
