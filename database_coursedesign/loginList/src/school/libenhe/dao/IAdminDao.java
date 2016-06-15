package school.libenhe.dao;

import school.libenhe.entity.Admin;

/**
 * 管理员访问数据接口
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-3 下午10:13:54
 */
public interface IAdminDao {

	/**
	 * 根据用户名&密码查询
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-2-3 下午10:42:29
	 * @param admin
	 * @return
	 */
	public Admin findByName(Admin admin);
}
