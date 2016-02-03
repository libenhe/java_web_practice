package school.libenhe.dao;

import java.util.List;

import school.libenhe.entity.Employee;

/**
 * 实验室学生人员数据接口
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-3 下午10:17:25
 */
public interface IEmployeeDao {

	/**
	 * 查询所用学生
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-2-3 下午10:43:54
	 * @return
	 */
	public List<Employee> getAll();
}
