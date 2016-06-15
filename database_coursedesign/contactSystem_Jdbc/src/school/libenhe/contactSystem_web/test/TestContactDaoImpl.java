package school.libenhe.contactSystem_web.test;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoImpl;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoMYSQLImpl;
import school.libenhe.contactSystem_web.entity.Contact;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * ContactdaoImpl测试类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-29 下午4:16:16
 */
public class TestContactDaoImpl {
	
ContactDao operator = null;
	
	/**
	 * 初始化对象实例
	 */
	@Before
	public void init(){
		operator = new ContactDaoMYSQLImpl();
	}
	

	@Test
	public void testAddContact(){
		Contact contact = new Contact();
		
		contact.setName("张三2");
		contact.setGender("男");
		contact.setAge(20);
		contact.setPhone("138888833333");
		contact.setEmail("er888888ic@qq.com");
		contact.setQq("38888884");
		operator.addContact(contact);
	}
	
	@Test
	public void testUpdateContact(){
		Contact contact = new Contact();
		contact.setId("5945b1d456ed41cfaa6954dd9e7a61b1"); //修改的ID
		contact.setName("李四");
		contact.setGender("女");
		contact.setAge(30);
		contact.setPhone("18888888888");
		contact.setEmail("zhangsan@qq.com");
		contact.setQq("338888884");
		contact.setEdu("dede");
		contact.setPchange("wu");
		operator.updateContact(contact);
	}
	
	@Test
	public void testDeleteContact(){
		operator.deleteContact("42dc576fbb4b4c6d849c87d532255d0c");
	}
	
	@Test
	public void testFindAll(){
		List<Contact> list = operator.findAll();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
	
	@Test
	public void testFindById(){
		Contact contact = operator.findById("8579e0410bf7466a93f714365fce34e3");
		System.out.println(contact);
	}
	
	@Test
	public void checkContact(){
		System.out.println(operator.checkContact("张三1"));
	}
}
