package school.libenhe.status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App1_status {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   // 测试时候使用
			.buildSessionFactory();
	}
	
	//1. 对象状态的转换
		@Test
		public void testSaveSet() throws Exception {
			Session session = sf.openSession();
			session.beginTransaction();
		}
}
