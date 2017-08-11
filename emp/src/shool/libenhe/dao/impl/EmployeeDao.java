package shool.libenhe.dao.impl;

import java.util.List;

import shool.libenhe.dao.IEmployeeDao;
import shool.libenhe.entity.Employee;
/**
 * 
 * @ClassName: EmployeeDao 
 * @Description: 员工接口实现类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-26 上午11:09:38
 *
 */
public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao{

	


	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String employeeName) {
		return getSessionFactory().getCurrentSession()//
			.createQuery("from Employee where empName like ?")//
			.setParameter(0, "%" +employeeName + "%")//
			.list();
	}
}
