package shool.libenhe.dao.impl;

import org.hibernate.SessionFactory;

import shool.libenhe.dao.IAdminDao;
import shool.libenhe.entity.Admin;
/**
 * 
 * @ClassName: AdminDao 
 * @Description: 管理员接口实现类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-26 上午11:09:00
 *
 */
public class AdminDao implements IAdminDao{

	//IOC容器(依赖)注入SessionFactory对象
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	;	this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
		
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		
		return (Admin) sessionFactory.getCurrentSession()//
				.createQuery("from Admin where adminName=? and pwd=?")//
				.setString(0, admin.getAdminName())
				.setString(1, admin.getPwd())
				.uniqueResult();
		        
	}

}
