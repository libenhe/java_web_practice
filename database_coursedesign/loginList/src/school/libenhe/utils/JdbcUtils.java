package school.libenhe.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC工具类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-3 下午10:45:58
 */
public class JdbcUtils {

	private static DataSource dataSource;
	
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static QueryRunner getQueryRunner() {
		
		return new QueryRunner(dataSource);
	}
}
