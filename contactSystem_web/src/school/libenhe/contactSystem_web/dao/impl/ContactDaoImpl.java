package school.libenhe.contactSystem_web.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.entity.Contact;
import school.libenhe.contactSystem_web.util.XmlUtil;

/**
 * Contact接口实现类
 * 
 * @project_name：contactSystem_web
 * @type_name：ContactDaoImpl
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-29 下午12:51:37
 * 
 */
public class ContactDaoImpl implements ContactDao {

	
	public void deleteContact(String id) {
		//读取联系人
		Document document = XmlUtil.getDocument();
		//查询要删除联系人的id
		Element contactElement = (Element)document.selectSingleNode("//contact[@id='"+id+"']");
		if (contactElement!=null) {
			contactElement.detach();
		}
		
		//Document写入到XML文件中
		XmlUtil.writeXml(document);

	}

	public void addContact(Contact contact) {

		File file = new File("e:/contact.xml");
		Document document = null;
		Element rootElement = null;

		/**
		 * 需求： 把contact对象保存到xml文件中
		 */
		if (!file.exists()) {
			// 如果没有XML文件则需要创建
			document = DocumentHelper.createDocument();
			// 创建根标签
			rootElement = document.addElement("contactList");
		} else {
			// 如果有XML文件，读取XML文件
			document = XmlUtil.getDocument();
			// 读取根标签
			rootElement = document.getRootElement();
		}

		// 添加contact标签
		/**
		 * <contact id="1"> 
		 * 		<name>libenhe</name>
		 *  	<gender>男</gender> 
		 *  	<age>20</age>
		 * 		<phone>9999999</phone> 
		 * 		<email>libenhe@qq.com</email> 
		 *  	<qq>8888888</qq>
		 * 		</contact>
		 */
		Element contactElement = rootElement.addElement("contact");

		
	    //由系统自动生成随机且唯一的ID值，赋值给联系人 
		String uuid = UUID.randomUUID().toString().replace("-", "");

		contactElement.addAttribute("id", uuid);
		
		contactElement.addElement("name").setText(contact.getName());
		contactElement.addElement("gender").setText(contact.getGender());
		contactElement.addElement("age").setText(contact.getAge()+ "");//转化为String类型
		contactElement.addElement("phone").setText(contact.getPhone());
		contactElement.addElement("email").setText(contact.getEmail());
		contactElement.addElement("qq").setText(contact.getQq());
		
		//写入到XML文件中
		XmlUtil.writeXml(document);
	}

	
	public void updateContact(Contact contact) {
		/**
		 * 需求： 修改id值为2的联系人
		 * 	1）查询id值为2的contact标签
		 *  2）修改contact标签的内容
		 */
		//1.读取xml文件
		Document doc = XmlUtil.getDocument();
		
		Element contactElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
		
		//2.修改contact标签内容
		contactElem.element("name").setText(contact.getName());
		contactElem.element("gender").setText(contact.getGender());
		contactElem.element("age").setText(contact.getAge()+"");
		contactElem.element("phone").setText(contact.getPhone());
		contactElem.element("email").setText(contact.getEmail());
		contactElem.element("qq").setText(contact.getQq());
		
		//3.把Document写出到xml文件
		XmlUtil.writeXml(doc);
		
	}


	public List<Contact> findAll() {
		//读取xml文件
		Document doc = XmlUtil.getDocument();
		
		//2.创建List对象
		List<Contact> list = new ArrayList<Contact>();
		//3.读取contact标签
		List<Element> conList = (List<Element>)doc.selectNodes("//contact");
		for(Element e:conList){
			//创建COntact对象
			Contact c = new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
			//把Contact放入list中
			list.add(c);
		}
		return list;
	}

	
	public Contact findById(String id) {
		Document doc = XmlUtil.getDocument();
		Element e = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		
		Contact c = null;
		if(e!=null){
			//创建Contact对象
			c = new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
		}
		return c;
	}
	/*public static void main(String[] args) {
		//测试UUID
		String uuid = UUID.randomUUID().toString().replace("-","");
		System.out.println(uuid);
	}
*/
}