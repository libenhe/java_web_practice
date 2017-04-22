package school.libenhe.extends1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 
 * @ClassName: App 
 * @Description: 简单继承映射测试类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-22 下午8:52:41
 *
 */
public class App {

	private static SessionFactory sf;
	
	static {
		sf = new Configuration()
		     .configure()
		     .addClass(Cat.class)   //测试时候使用
		     .buildSessionFactory();
	}
	
	@Test
	public void setSave() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Cat cat = new Cat();
		cat.setName("小白猫");
		cat.setEatMouse("抓老鼠吃");
		
		session.save(cat);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void getQuery() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from school.libenhe.extends1.Animal");
		
		List<Cat> list = query.list();
		
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
