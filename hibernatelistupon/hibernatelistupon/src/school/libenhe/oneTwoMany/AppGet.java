package school.libenhe.oneTwoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class AppGet {

	private static SessionFactory sf;
	
	static {
		sf = new Configuration()
		     .configure()
		     .addClass(Dept.class)
		     .addClass(Employee.class)
		     .buildSessionFactory();
	}
	
	@Test
	public void get() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, 1);
		
		System.out.println(employee.getEmpName());
		System.out.println(employee.getDept().getDeptName());
		
		session.getTransaction().commit();
		session.close();
	}
	
}


