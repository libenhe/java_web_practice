package school.libenhe.contactSystem_web.dao;

import java.util.List;

import school.libenhe.contactSystem_web.entity.Contact;

/**
 * Contact联系人的Dao接口
 * 
 * @project_name：contactSystem_web
 * @type_name：ContactDao
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-29 下午12:53:35
 * 
 */
public interface ContactDao {

	public void addContact(Contact contact);// 添加联系人

	public void updateContact(Contact contact);// 修改联系人

	public void deleteContact(String id);// 删除联系人

	public List<Contact> findAll(); // 查询所有联系人

	public Contact findById(String id);// 根据编号查询联系人

}
