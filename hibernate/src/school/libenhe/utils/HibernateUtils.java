package school.libenhe.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @ClassName: HibernateUtils 
 * @Description: 工具类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-3-24 上午11:23:51
 *
 */
public class HibernateUtils {

	private static SessionFactory sf;
	static {
		//加载文件并创建Session的工厂
		sf = new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession() {
		return sf.openSession();
	}
	
}
