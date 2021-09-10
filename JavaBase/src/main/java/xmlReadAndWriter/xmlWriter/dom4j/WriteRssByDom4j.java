package xmlReadAndWriter.xmlWriter.dom4j;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
/**	使用Dom4j形式生成RSS文件*/
public class WriteRssByDom4j {

	public static void main(String[] args) throws Exception{
		//创建输出文件对象
		File xml = new File("src/xmlReadAndWriter/xmlWriter/News.xml");
		//创建Document对象
		Document document = DocumentHelper.createDocument();
		//创建根节点<rss>
		Element rootRss = document.addElement("rss");
		//描述根节点,增加属性
		rootRss.addAttribute("version", "3.0");
		//生成子节点,及内容
		Element channel = rootRss.addElement("channel");	//子节点<channel>
		channel.setText("新闻频道");
		Element title = rootRss.addElement("title");	//子节点<title>
		title.setText("肚子饿了!!...>o<...");
		//设置格式
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("GBK");	 			//在格式输出时,设置GBK编码
		//生成xml文件
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xml),outputFormat );
		xmlWriter.setEscapeText(false);					//设置是否进行转移,将文本中的字符进行转移
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
