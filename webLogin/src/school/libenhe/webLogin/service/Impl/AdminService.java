package school.libenhe.webLogin.service.Impl;

import school.libenhe.webLogin.dao.IAdminDao;
import school.libenhe.webLogin.dao.Impl.AdminDao;
import school.libenhe.webLogin.entity.Admin;
import school.libenhe.webLogin.exception.UserExistException;
import school.libenhe.webLogin.service.IAdminService;

/**
 * 业务逻辑层实现类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午8:44:12
 */
public class AdminService implements IAdminService {

	private IAdminDao adminDao = new AdminDao();

	@Override
	
	public void register(Admin admin) throws UserExistException  {
		
		try {
			// 1. 先根据用户名查询用户是否存在
			boolean flag = adminDao.userExist(admin.getUserName());
			
			// 2. 如果用户存在，不允许注册
			if (flag){
				// 不允许注册, 给调用者提示
				throw new UserExistException("用户名已经存在，注册失败！");
			}
			
			// 3. 用户不存在，才可以注册
			adminDao.save(admin);
		
		} catch (UserExistException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Admin login(Admin admin) {

		try {
			return adminDao.findByUserNameAndPassWord(admin);
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
	}

}
