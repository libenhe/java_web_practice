package school.libenhe.service.impl;

import school.libenhe.dao.IAdminDao;
import school.libenhe.dao.impl.AdminDao;
import school.libenhe.entity.Admin;
import school.libenhe.service.IAdminService;

/**
 * 管理员Service接口实现类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-4 上午9:37:48
 */
public class AdminService implements IAdminService{

	IAdminDao adminDao = new AdminDao();
	@Override
	public Admin findByName(Admin admin) {
		
		return adminDao.findByName(admin);
	}

}
