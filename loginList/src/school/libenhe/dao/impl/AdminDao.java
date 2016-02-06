package school.libenhe.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mysql.jdbc.JDBC4CallableStatement;

import school.libenhe.dao.IAdminDao;
import school.libenhe.entity.Admin;
import school.libenhe.utils.JdbcUtils;

/**
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-3 下午10:14:27
 */
public class AdminDao implements IAdminDao {

	@Override
	public Admin findByName(Admin admin) {

		String sql = "select * from admin where userName=? and pwd=?";
		try {
			return JdbcUtils.getQueryRunner()
					.query(sql,
					new BeanHandler<Admin>(Admin.class), 
					admin.getUserName(),
					admin.getPwd());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}