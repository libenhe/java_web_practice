package school.libenhe.test;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import school.libenhe.entity.Dept;
import school.libenhe.service.DeptService;



public class App {

	// 容器
		private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

		@Test
		public void testApp() throws Exception {
			DeptService deptServie = (DeptService) ac.getBean("deptService");
			System.out.println(deptServie.getClass());
			
			deptServie.save(new Dept());
	}
}
