package school.libenhe.contactSystem_web.service;

import java.util.List;

import school.libenhe.contactSystem_web.entity.Contact;
import school.libenhe.contactSystem_web.exception.NameRepeatException;

/**
 * 业务逻辑处理接口
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-14 上午10:11:14
 */
public interface ContactService {
	
	public void addContact(Contact contact)throws NameRepeatException;//添加联系人
	public void updateContact(Contact contact);//修改联系人
	public void deleteContact(String id);//删除联系人
	public List<Contact> findAll();  //查询所有联系人
	public Contact findById(String id);//根据编号查询联系人
	
}
