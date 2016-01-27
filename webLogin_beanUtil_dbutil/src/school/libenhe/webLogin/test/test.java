package school.libenhe.webLogin.test;

import org.junit.Test;

import school.libenhe.webLogin.dao.Impl.AdminDao;
import school.libenhe.webLogin.entity.Admin;

/**
 * 测试类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-26 下午12:12:46
 */
public class test {

	/**
	 * 测试save
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-26 下午12:29:18
	 */
	@Test
	public void test() {
		Admin testAdmin = new Admin();
		testAdmin.setUserName("ll");
		testAdmin.setPassWord("123");
		
		AdminDao testAdminDao = new AdminDao();
		testAdminDao.save(testAdmin);
	}

}
