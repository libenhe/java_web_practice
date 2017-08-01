package shool.libenhe.service.impl;

import java.util.List;

import shool.libenhe.dao.IDeptDao;
import shool.libenhe.entity.Dept;
import shool.libenhe.service.IDeptService;

public class DeptService implements IDeptService{
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	@Override
	public List<Dept> getAll() {
		
		return deptDao.getAll();
	}
	@Override
	public Dept findById(int id) {
		
		return deptDao.findById(id);
	}
	

}
