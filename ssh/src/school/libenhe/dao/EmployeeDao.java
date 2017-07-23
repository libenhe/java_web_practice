package school.libenhe.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import school.libenhe.entity.Employee;

public class EmployeeDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Employee findById(Serializable id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}
}
