package school.libenhe.first;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

/**
 * 
 * @ClassName: App3 
 * @Description: HQL语句查询
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-3-20 下午4:46:05
 *
 */
public class App3 {
 
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	/**
	 * 查询
	 * @throws Exception
	 */
	@Test
	public void testQuery() throws Exception {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
        
		Query query = session.createQuery("from Employee where empId = 1 ");
	 
		List<Employee> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 完全面向对象查询
	 * @throws Exception
	 */
	@Test
	public void testQBC() throws Exception {
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empId", 1));
		
		List<Employee> list = criteria.list();
		
		System.out.println(list);
		transaction.commit();
		session.close();
	}
	
}
