package school.libenhe.service;

import java.io.Serializable;

import school.libenhe.dao.EmployeeDao;
import school.libenhe.entity.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	/***
	 *  查询
	 * @param id
	 * @return
	 */
	public Employee findById(Serializable id) {
		Employee emp = employeeDao.findById(id);
	  return	emp;
	}
	
}
