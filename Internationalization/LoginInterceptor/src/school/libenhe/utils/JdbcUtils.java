package school.libenhe.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-2-10 下午12:25:34
 */
public class JdbcUtils {

	//初始化
	private static DataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * 创建DBUtils常用的工具类对象
	 */
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}
}
