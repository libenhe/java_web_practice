package school.libenhe.service;

import school.libenhe.entity.Admin;

/**
 * 管理员业务逻辑管理层
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-4 上午9:37:00
 */
public interface IAdminService {

	/**
	 * 根据用户名&密码查询
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-2-4 上午9:49:18
	 * @param admin
	 * @return
	 */
	public Admin findByName(Admin admin);
}
