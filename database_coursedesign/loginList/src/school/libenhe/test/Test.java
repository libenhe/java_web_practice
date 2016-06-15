package school.libenhe.test;

import school.libenhe.dao.IAdminDao;
import school.libenhe.dao.IEmployeeDao;
import school.libenhe.dao.impl.AdminDao;
import school.libenhe.dao.impl.EmployeeDao;
import school.libenhe.entity.Admin;

/**
 * 测试类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-26 下午12:12:46
 */
public class Test {

	/**
	 * 测试数据库是否连接
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-2-6 下午6:49:03
	 */
	@org.junit.Test
	
	public void test1() {
		Admin admin1 = new Admin();
		Admin admin2 = new Admin();
		admin1.setUserName("123");
		admin1.setPwd("123456");
		IAdminDao adminDao = new AdminDao();
		admin2 = adminDao.findByName(admin1);
		System.out.println(admin2.getUserName());
	}

}
