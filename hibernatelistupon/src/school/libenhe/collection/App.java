package school.libenhe.collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	
	static {
		sf = new Configuration()
		     .configure()
		     .addClass(User.class)  //加载映射，测试时使用，常规开发应在配置文件中加载映射
		     .buildSessionFactory();
	}
	
	//保存set
	@Test                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	public void testSaveSet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("杭州");
		addressSet.add("湖南");
		
		//用户对象
		
		User user = new User();
		user.setUserName("libenhe");
		user.setAddress(addressSet);
		
		session.save(user);
		
		session.getTransaction().commit();
		 session.close();
		
	}
	
	public void testSaveList() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		Set<String> addressSet = new HashSet<String>();
	
		
		User user = new User();
		user.setUserName("libenheList");
		//用户对象----map
		
		user.getAddressMap().put("001", "黑龙江");
		user.getAddressMap().put("002", "张家界");
		
		//保存
		session.save(user);
		
		session.getTransaction().commit();
		 session.close();
		
	}
	
	public void testGet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, 2);
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		
		/**
		 * 当查询用户，同时可以获取用户关联的list集合的数据（因为有正确的映射）
		 * 当使用到集合数据的使用，才向数据库发送执行的sql语句（懒加载）
		 */
		System.out.println(user.getAddressList());
		
		//保存
		session.save(user);
		
		session.getTransaction().commit();
		 session.close();
		
	}
	
	
}














