package school.libenhe.webLogin.dao;

import school.libenhe.webLogin.entity.Admin;

/**
 * 数据库dao层接口
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午7:18:08
 */
public interface IAdminDao {

	/**
	 * 保存
	 * 
	 * @author：LiBenhe E-mail：libenhe919@163.com
	 * @version： 2016-1-25 下午7:24:31
	 * @param admin
	 */
	void save(Admin admin);

	/**
	 * 根据用户和密码查询
	 * 
	 * @author：LiBenhe E-mail：libenhe919@163.com
	 * @version： 2016-1-25 下午7:26:17
	 * @param admin
	 * @return
	 */
	Admin findByUserNameAndPassWord(Admin admin);
	
	/**
	 * 查询用户是否存在
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-25 下午7:27:35
	 * @param name 用户名
	 * @return
	 */
	boolean userExist(String name);
}
