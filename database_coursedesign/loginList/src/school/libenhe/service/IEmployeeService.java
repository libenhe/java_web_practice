package school.libenhe.service;

import java.util.List;

import school.libenhe.entity.Employee;

/**
 * 实验室学生业务逻辑管理层
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-4 上午9:44:53
 */
public interface IEmployeeService {

	/**
	 * 查询所用
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-2-4 上午9:50:34
	 * @return
	 */
	public List<Employee> getAll();
}
