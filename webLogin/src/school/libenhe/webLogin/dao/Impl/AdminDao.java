package school.libenhe.webLogin.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import school.libenhe.webLogin.dao.IAdminDao;
import school.libenhe.webLogin.entity.Admin;
import school.libenhe.webLogin.utils.JdbcUtil;

/**
 * IAdmin接口实现类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午7:37:26
 */
public class AdminDao implements IAdminDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	@Override	
	public void save(Admin admin) {
		
		String sql = "INSERT INTO Admin(userName, pwd) VALUES(?,?);";
		try {       
			connection = JdbcUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getUserName());
			preparedStatement.setString(2, admin.getPassWord());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
	}

	@Override
	public Admin findByUserNameAndPassWord(Admin admin) {
		
		String sql = "SELECT * FROM admin WHERE userName = ? AND pwd = ?;";
		Admin ad = null;
		try {	
			connection = JdbcUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getUserName());
			preparedStatement.setString(2, admin.getPassWord());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			ad = new Admin();
			ad.setId(resultSet.getInt("id"));
			ad.setUserName(resultSet.getString("userName"));
			ad.setPassWord(resultSet.getString("pwd"));
			}
			return ad;
		} catch (SQLException e) {
		throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
	}

	@Override
	public boolean userExist(String name) {
		String sql = "SELECT id FROM Admin WHERE userName = ?;";
		try {
			connection = JdbcUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				if (id > 0){
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
		throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
	}

}
