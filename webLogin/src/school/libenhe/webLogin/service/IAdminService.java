package school.libenhe.webLogin.service;

import school.libenhe.webLogin.entity.Admin;
import school.libenhe.webLogin.exception.UserExistException;

/**
 * 业务逻辑层处理接口
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午8:43:45
 */
public interface IAdminService {

	/**
	 * 注册
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-25 下午8:49:48
	 * @param admin
	 * @throws UserExistException 自定义用户异常处理
	 */
	void register(Admin admin) throws UserExistException;
	
	/**
	 * 登陆
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-25 下午8:50:48
	 * @param admin
	 * @return
	 */
	Admin login(Admin admin);
}
