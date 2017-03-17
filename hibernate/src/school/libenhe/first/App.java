package school.libenhe.first;

import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-3-16 下午9:04:01
 */
public class App {

	@Test
   public void test() throws Exception{
		
	   Employee employee = new Employee();
	   employee.setEmpName("libenhe");
	   employee.setWorkDate(new Date());
	   
	   Configuration configuration = new Configuration();
	   
	   configuration.configure();
	   SessionFactory sf = configuration.buildSessionFactory();
	   
	   Session session = sf.openSession();
	   
	   Transaction tx = session.beginTransaction();
	   
	   session.save(employee);
	   tx.commit();
	   session.close();
	   sf.close();
	   
   }
}
