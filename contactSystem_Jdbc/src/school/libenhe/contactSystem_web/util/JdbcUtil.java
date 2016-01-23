package school.libenhe.contactSystem_web.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

/**
 * JdbcUtil工具类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-22 下午6:21:49
 */
public class JdbcUtil {
	
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	
	/***
	 * 使用静态加载
	 */
	static {
		try {
			//读取db.properties文件
			Properties properties = new Properties();
			//使用类路径读取配置文件
			InputStream inputStream = JdbcUtil.class.getResourceAsStream("/db.properties");
			//加载properties文件
			properties.load(inputStream);
			
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			driverClass = properties.getProperty("driverClass");
		
			//注册驱动
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动注册出错！");
		}
	}
	/*@Test
	*//**
	 * 调试测试url等是否传入值
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-22 下午10:20:28
	 *//*
	public void test() {
		System.out.println(password);
	}
	*/
	/**
	 * 链接对象的方法
	 */
	
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/***
	 * 释放资源
	 */
	
	public static void close(Connection connection, Statement statement) {
		
		if (statement != null) {
			try {
				statement.close();
				statement = null;  //回收
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		
		if (resultSet != null) {
			try {
				resultSet.close();
				resultSet = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
