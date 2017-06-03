package school.libenhe.query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/***
 * 
 * @ClassName: App_criteria
 * @Description: 测试类 Criteria查询
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-5-2 下午8:27:05
 * 
 */
public class App_criteria {

	private static SessionFactory sf;

	static {

		sf = new Configuration().configure().addClass(Dept.class)
				.addClass(Employee.class).buildSessionFactory();
	}

	public void criteria() {
		Session session = sf.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);

		// 创建条件
		criteria.add(Restrictions.eq("empId", 12));

		System.out.println(criteria.list());

		session.getTransaction().commit();
		session.close();
		
	}
	
}
