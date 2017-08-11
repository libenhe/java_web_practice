package shool.libenhe.service;

import shool.libenhe.entity.Admin;

/**
 * 
 * @ClassName: IAdminService 
 * @Description: 管理员业务逻辑接口
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-31 上午10:15:24
 *
 */
public interface IAdminService {

	/**
	 *  注册
	 * @param admin
	 */
	void register(Admin admin);

	/**
	 *  登陆
	 * @param admin
	 * @return
	 */
	Admin login(Admin admin);
}
