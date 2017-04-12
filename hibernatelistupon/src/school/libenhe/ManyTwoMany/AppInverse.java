package school.libenhe.ManyTwoMany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/***
 * 
 * @ClassName: AppInverse 
 * @Description: 属性对保存对象的影响
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-12 下午3:46:10
 *
 */
public class AppInverse {


	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Project.class)   
			.addClass(Developer.class)   // 测试时候使用
			.buildSessionFactory();
	}

	
}
