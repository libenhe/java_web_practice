package school.libenhe.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession() {
	// 线程的方式创建session，必须要配置, 可以不用关闭，会自动关。
		return sf.getCurrentSession();
	}
}
