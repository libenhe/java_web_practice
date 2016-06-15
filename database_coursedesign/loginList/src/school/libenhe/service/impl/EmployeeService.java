package school.libenhe.service.impl;

import java.util.List;

import school.libenhe.dao.IEmployeeDao;
import school.libenhe.dao.impl.EmployeeDao;
import school.libenhe.entity.Employee;
import school.libenhe.service.IEmployeeService;

/**
 * 实验室学生Service接口实现类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-4 上午9:40:06
 */
public class EmployeeService implements IEmployeeService{

	IEmployeeDao employeeDao = new EmployeeDao();
	@Override
	public List<Employee> getAll() {
		
		return employeeDao.getAll();
	}

}
