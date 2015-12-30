package school.libenhe.contactSystem_web.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * XML的工具类,包括读取XML文档以及写入XML文档
 * 
 * @project_name：contactSystem_web
 * @type_name：XmlUtil
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-29 下午12:55:01
 * 
 */
public class XmlUtil {

	/**
	 * 读取XML文档的方法
	 * 
	 * @author：LiBenhe E-mail：libenhe919@163.com
	 * @version： 2015-12-29 下午1:02:58
	 * @return document
	 */
	public static Document getDocument() {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("e:/contact.xml"));
			return document;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 写入到XML文档中
	 * 
	 * @author：LiBenhe E-mail：libenhe919@163.com
	 * @version： 2015-12-29 下午1:11:06
	 * @param document
	 */
	public static void writeXml(Document document) {

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					"e:/contact.xml");
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(fileOutputStream, outputFormat);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
