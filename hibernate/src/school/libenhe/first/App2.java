package school.libenhe.first;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-3-18 下午2:03:00
 */
public class App2 {
    
	private static SessionFactory sf;
	
	static {
		/*
		//1. 创建配置管理类对象
		Configuration config = new Configuration();
		// 加载配置文件  (默认加载src/hibernate.cfg.xml)
		config.configure();
		//2. 根据加载的配置管理类对象，创建SessionFactory对象
		sf = config.buildSessionFactory();
		*/
		sf = new Configuration().configure().buildSessionFactory();
		
	}
	/***
	 * 保存：Hibernate: insert into employee (empName, workDate) values (?, ?)
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2017-3-18 下午2:49:24 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception{
	
		Employee employee = new Employee();
		employee.setEmpName("符莉");
		employee.setWorkDate(new Date());
		
		Session session  = sf.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
	}
	/** 
	 * 更新  Hibernate: update employee set empName=?, workDate=? where id=?
	 */
	@Test
	public void testUpdate() throws Exception {
		Employee emp2 = new Employee();
		emp2.setEmpId(1);
		emp2.setEmpName("SB");
		emp2.setWorkDate(new Date());
		Session session = sf.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(emp2);
		transaction.commit();
		session.close();
	}
 	
	
}
