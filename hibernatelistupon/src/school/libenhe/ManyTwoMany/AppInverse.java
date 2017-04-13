package school.libenhe.ManyTwoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

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
		sf = new Configuration().configure()
				.addClass(Project.class)
				.addClass(Developer.class) // 测试时候使用
				.buildSessionFactory();
	}

	// 多对多
	// 1. 设置inverse属性，对保存数据影响?
	// 有影响。
	// inverse=false ，有控制权，可以维护关联关系； 保存数据的时候会把对象关系插入中间表；
	// inverse=true, 没有控制权， 不会往中间表插入数据。
	@Test
	public void save() {
		Session session = sf.openSession();
		session.beginTransaction();

		// 创建项目对象

		Project project_lrhl = new Project();
		project_lrhl.setProName("老人健康护理项目");
		Project project_dxzj = new Project();
		project_dxzj.setProName("大学之家");

		// 创建成员对象

		Developer developer_lbh = new Developer();
		developer_lbh.setDevName("李本贺");

		Developer developer_fl = new Developer();
		developer_fl.setDevName("符莉");

		Developer developer_tck = new Developer();
		developer_tck.setDevName("谭琛琨");

		// 关系
		project_lrhl.getDevelopers().add(developer_lbh);
		project_lrhl.getDevelopers().add(developer_fl);

		project_dxzj.getDevelopers().add(developer_lbh);
		project_dxzj.getDevelopers().add(developer_tck);

		// 保存
		//
		// session.save(developer_lbh);
		// session.save(developer_fl);
		// session.save(developer_tck);

		session.save(project_lrhl); // 前提需要设置级联保存
		session.save(project_dxzj);

		session.getTransaction().commit();
		session.close();
	}

	// 2 设置inverse属性， 对获取数据影响？ 无
	@Test
	public void get() {

		Session session = sf.openSession();
		session.beginTransaction();

		Project project = (Project) session.get(Project.class, 1);

		System.out.println(project.getProName());
		System.out.println(project.getDevelopers());

		session.getTransaction().commit();
		session.close();

	}

}
