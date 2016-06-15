package school.libenhe.contactSystem_web.service.impl;

import java.util.List;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoImpl;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoMYSQLImpl;
import school.libenhe.contactSystem_web.entity.Contact;
import school.libenhe.contactSystem_web.exception.NameRepeatException;

import school.libenhe.contactSystem_web.service.ContactService;

/**
 * 业务逻辑处理接口实现
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-14 上午10:12:47
 */

public class ContactServiceImpl implements ContactService {

	//ContactDao contactDao = new ContactDaoImpl();
	ContactDao contactDao = new ContactDaoMYSQLImpl();
	@Override
	public void addContact(Contact contact) throws NameRepeatException {

		// 执行业务逻辑判断
		if (contactDao.checkContact(contact.getName())) {
			// 自定义异常类处理
			throw new NameRepeatException("重复不可用！");
		}
		contactDao.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {

		contactDao.updateContact(contact);

	}

	@Override
	public void deleteContact(String id) {

		contactDao.deleteContact(id);
	}

	@Override
	public List<Contact> findAll() {

		return contactDao.findAll();
	}

	@Override
	public Contact findById(String id) {
		return contactDao.findById(id);
	}

}
