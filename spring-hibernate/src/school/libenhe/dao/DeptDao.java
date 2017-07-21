package school.libenhe.dao;

import org.hibernate.SessionFactory;

import school.libenhe.entity.Dept;

public class DeptDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//保存一条记录
public void save(Dept dept) {
	sessionFactory.getCurrentSession().save(dept);

}	
}
