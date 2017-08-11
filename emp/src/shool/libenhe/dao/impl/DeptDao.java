package shool.libenhe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import shool.libenhe.dao.IDeptDao;
import shool.libenhe.entity.Dept;
/**
 * 
 * @ClassName: DeptDao 
 * @Description: 部门模块接口实现类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-26 上午11:09:19
 *
 */
public class DeptDao implements IDeptDao{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Dept> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

	@Override
	public Dept findById(int id) {
		
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}

}
