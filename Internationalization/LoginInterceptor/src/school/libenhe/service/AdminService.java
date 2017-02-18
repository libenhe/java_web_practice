package school.libenhe.service;

import java.util.List;

import school.libenhe.dao.AdminDao;
import school.libenhe.entity.Admin;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-2-10 下午9:36:29
 */
public class AdminService {

	private AdminDao  adminDao = new AdminDao();
	
	public Admin login(Admin admin) {
		try {
			return adminDao.login(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Admin> getAll() {
		try {
			return adminDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
