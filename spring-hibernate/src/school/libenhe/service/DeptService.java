package school.libenhe.service;

import school.libenhe.dao.DeptDao;
import school.libenhe.entity.Dept;

public class DeptService {

	private DeptDao deptDao;
	
	public void setDpetDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public void save(Dept dept) {
		deptDao.save(dept);
	}
}
