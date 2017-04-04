package school.libenhe.oneTwoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {


	private static SessionFactory sf;
	
	static {
		sf = new Configuration()
		     .configure()
		     .addClass(Dept.class)  //加载映射，测试时使用，常规开发应在配置文件中加载映射
		     .addClass(Employee.class)
		     .buildSessionFactory();
	}
	
	/**
	 * 保存：部门：（以一对一的方式操作）
	 */
	@Test
	public void save() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		//部门
		Dept dept = new Dept();
		dept.setDeptName("后端开发");
		//员工 
		Employee employee_lbh = new Employee();
		employee_lbh.setEmpName("李本贺");
		Employee employee_fl = new Employee();
		employee_fl.setEmpName("符莉");
		dept.getEmps().add(employee_fl);
		dept.getEmps().add(employee_lbh);
		
		session.save(employee_fl);
		session.save(employee_lbh);
		session.save(dept);
		
		session.getTransaction().commit();
		session.close();
	}
}














