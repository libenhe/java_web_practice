package school.libenhe.oneTwoMany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppInverse {


	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
	
	
}
