package school.libenhe.ManyTwoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class AppSave {

	private static SessionFactory sf;
	static {
		
		sf = new Configuration()
		      .configure()
		      .addClass(Developer.class)//测试shihou-使用
		      .addClass(Project.class)
		      .buildSessionFactory();
	}
	
	@Test
	public void save() {
	
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*
		 * 模拟数据： 
			老人健康护理项目（李本贺、符莉）
			大学之家（李本贺、谭琛琨）
		 */
		
		//创建项目对象
		
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
	    
	    //关系
	    project_lrhl.getDevelopers().add(developer_lbh);
	    project_lrhl.getDevelopers().add(developer_fl);
	    
	    project_dxzj.getDevelopers().add(developer_lbh);
	    project_dxzj.getDevelopers().add(developer_tck);
	    
	    //保存
	    session.save(developer_lbh);
	    session.save(developer_fl);
	    session.save(developer_tck);
	    
	    session.save(project_lrhl);
	    session.save(project_dxzj);
	    
	    session.getTransaction().commit();
	    session.close();
	}
	
}




