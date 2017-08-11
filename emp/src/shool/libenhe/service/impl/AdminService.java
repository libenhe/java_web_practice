package shool.libenhe.service.impl;

import shool.libenhe.dao.IAdminDao;
import shool.libenhe.entity.Admin;
import shool.libenhe.service.IAdminService;

public class AdminService implements IAdminService {

	private IAdminDao adminDao;

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void register(Admin admin) {
		adminDao.save(admin);

	}

	@Override
	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
	}

}
