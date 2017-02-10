package school.libenhe.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import school.libenhe.entity.Admin;
import school.libenhe.utils.JdbcUtils;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-2-10 下午12:33:38
 */
public class AdminDao {

	public Admin login(Admin admin) {
	
		String sql = "select * from admin where userName=? and pwd=?";
		try {
			return JdbcUtils.getQueryRunner()
					.query(
					       sql,
					       new BeanHandler<Admin>(Admin.class),
					       admin.getUserName(),
					       admin.getPwd()
							);
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
	
	public List<Admin> getAll() {
		String sql = "select * from admin ";
		try {
			return JdbcUtils.getQueryRunner()
				.query(
					sql, 
					new BeanListHandler<Admin>(Admin.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
