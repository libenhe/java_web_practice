package school.libenhe.service;

import school.libenhe.dao.UserDao;

public class UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save() {
		userDao.save();
	}
	
}
