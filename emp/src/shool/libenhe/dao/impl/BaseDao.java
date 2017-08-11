package shool.libenhe.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import shool.libenhe.dao.IBaseDao;

/**
 * 
 * @ClassName: BaseDao 
 * @Description: 所有dao的通用操作实现类，含有通用操作的dao类继承此类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-8 下午4:13:59
 *
 */
public class BaseDao<T> implements IBaseDao<T> {

	private Class<T> clazz;
	private String className;
	
	
	
	//反射泛型
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		// 转换为参数化类型
		ParameterizedType pt = (ParameterizedType) type;
		// 得到实际类型
		Type types[] = pt.getActualTypeArguments();
		//获取实际类型
		clazz = (Class<T>) types[0];
		//获取名字
		className = clazz.getName();
	}
	
	//容器注入
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	
	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession()
		.createQuery("delete from" + className+ "where id=?")
		.setParameter(0, id).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from" + className).list();
	}

	
}
