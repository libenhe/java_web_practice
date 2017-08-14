package school.libenhe.emp.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @ClassName: JdbcUtil 
 * @Description: Jdbc工具类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-14 上午10:44:54
 *
 */
public class JdbcUtil {

	//加载C3P0配置文件
	private static ComboPooledDataSource  dataSource = new ComboPooledDataSource();
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
}
