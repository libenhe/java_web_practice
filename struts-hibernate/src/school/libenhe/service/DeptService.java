package school.libenhe.service;

import school.libenhe.dao.DeptDao;
import school.libenhe.entity.Dept;

public class DeptService {

	//调用Dao
	private DeptDao deptDao = new DeptDao();
	
	public Dept findById(int id) {
		return deptDao.findById(id);
	}
}
