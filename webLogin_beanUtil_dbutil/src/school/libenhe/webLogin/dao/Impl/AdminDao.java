package school.libenhe.webLogin.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.inject.New;
import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import school.libenhe.webLogin.dao.IAdminDao;
import school.libenhe.webLogin.entity.Admin;
import school.libenhe.webLogin.utils.JdbcUtil;

/**
 * IAdmin接口实现类(采用dbutils组件简化数据库操作)
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午7:37:26
 */
public class AdminDao implements IAdminDao {

	private Connection connection;
	private QueryRunner queryRunner = new QueryRunner();
	
	@Override	
	public void save(Admin admin) {
		
		String sql = "INSERT INTO Admin(userName, pwd) VALUES(?,?);";
		try {       
			connection = JdbcUtil.getConnection();
		   queryRunner.update(connection, sql, admin.getUserName(), admin.getPassWord());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
	}

	@Override
	public Admin findByUserNameAndPassWord(Admin admin) {
		
		String sql = "SELECT * FROM admin WHERE userName = ? AND pwd = ?;";
		
		try {       
			connection = JdbcUtil.getConnection();
		   Admin ad = queryRunner.query(connection, sql,
		    		new BeanHandler<Admin>(Admin.class),
		    		admin.getUserName(),
		    		admin.getPassWord());
		   return ad;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
	}

	@Override
	public boolean userExist(String name) {
		String sql = "SELECT id FROM Admin WHERE userName = ?;";
		try {
			connection = JdbcUtil.getConnection();
			Integer id = queryRunner.query(connection, sql, new ScalarHandler<Integer>(), name);
				if (id != null){
					return true;
				}
			return false;
		} catch (SQLException e) {
		throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
	}

}
