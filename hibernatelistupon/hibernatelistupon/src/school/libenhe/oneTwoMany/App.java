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
	 * 执行语句
	 * Hibernate: insert into t_employee (empName, dept_id) values (?, ?)
     * Hibernate: insert into t_employee (empName, dept_id) values (?, ?)
     * Hibernate: insert into t_dept (deptName) values (?)
     * Hibernate: update t_employee set deptId=? where empId=?
     * Hibernate: update t_employee set deptId=? where empId=?
	 */
	@Test
	public void save() throws Exception{
		
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
	
	/**
	 * 多对一执行操作
	 * 
	 */
	    @Test
	public void saveManyTwoOne() {
		Session session = sf.openSession();
		session.beginTransaction();
		Dept dept = new Dept();
		dept.setDeptName("前端开发部");
		Employee employee_lx = new Employee();
		employee_lx.setEmpName("李杏");
		Employee employee_tck = new Employee();
		employee_tck.setEmpName("谭琛琨");
		employee_lx.setDept(dept);
		employee_tck.setDept(dept);
		
		
		//保存:现存One后存Many
		
		session.save(dept);
		session.save(employee_tck);
		session.save(employee_lx);
		
		session.getTransaction().commit();
		session.close();
	}
}














