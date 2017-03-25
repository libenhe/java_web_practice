package school.libenhe.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import school.libenhe.first.Employee;
import school.libenhe.utils.HibernateUtils;

/**
 * 
 * @ClassName: EmployeeDaoImpl
 * @Description: 接口实现类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-3-24 上午11:15:29
 * 
 */
public class EmployeeDaoImpl implements IEmployeeDao {

	@Override                   
	public void save(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
			session.save(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 
		
	}

	@Override
	public void update(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
			session.update(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 
		

	}

	@Override
	public Employee findById(Serializable id) {
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
			return (Employee) session.get(Employee.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 
		
		
	}

	@Override
	public List<Employee> getAll() {
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			return query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 
		
	}

	@Override
	public List<Employee> getAll(String employeeName) {
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
			Query query = session.createQuery("from Employee where empName=?");
			//参数索引从0开始
			query.setParameter(0, employeeName);
			return query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 
		
	}

	@Override
	public List<Employee> getAll(int index, int count) {
		
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			//设置分页参数
			query.setFirstResult(index);
			query.setMaxResults(count);
			List<Employee> list = query.list();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 
		
	}

	@Override
	public void delete(Serializable id) {
		Session session = null;
		Transaction transaction = null;
		try {
		    session = HibernateUtils.getSession();
		    transaction = session.beginTransaction();
		//先查询到对象，后判断然后删除
		    Object obj = session.get(Employee.class, id);
		    if (obj != null) {
				session.delete(obj);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			transaction.commit();
			session.close();
		} 

	}

}
