package shool.libenhe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

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
public class EmployeeDao implements IEmployeeDao{

	//容器注入
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	@Override
	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
		
	}

	@Override
	public void update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
		
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession()//
		              .createQuery("delete from Employee where id=?")//
		              .setParameter(0, id)
		              .executeUpdate();
		
	}

	@Override
	public Employee findById(int id) {
		
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String employeeName) {
		
		return sessionFactory.getCurrentSession()//
				.createQuery("from Employee where empName like ?")//
				.setParameter(0, "%"+employeeName+"%")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

}
