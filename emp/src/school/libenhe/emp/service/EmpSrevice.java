package school.libenhe.emp.service;

import school.libenhe.emp.dao.IEmpDao;
import school.libenhe.emp.entity.Emp;

public class EmpSrevice {

	private IEmpDao empDao;
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}
	
	/**
	 * 增加员工
	 */
	public void register(Emp emp) throws Exception{
		empDao.add(emp);
	}
}
