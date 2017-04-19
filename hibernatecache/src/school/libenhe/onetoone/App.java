package school.libenhe.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 
 * @ClassName: App 
 * @Description: 测试类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-18 下午3:37:53
 *
 */
public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   
			.addClass(IdCard.class)   // 测试时候使用
			.buildSessionFactory();
	}
	/**
	 *  测试保存
	 */
	@Test
	public void setSave() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("李本贺");
		
		IdCard idCard = new IdCard();
		idCard.setCardNum("230622XXXXXX7056");
		idCard.setPlace("黑龙江");
		
		idCard.setUser(user);
		
		session.save(idCard);
		
		session.getTransaction().commit();
		session.close();
	}
	
}




























