package school.libenhe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import school.libenhe.dao.IEmployeeDao;
import school.libenhe.entity.Employee;
import school.libenhe.utils.JdbcUtils;

/**
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-3 下午10:17:47
 */
public class EmployeeDao implements IEmployeeDao{

	@Override
	public List<Employee> getAll() {
		String sql = "select * from employee";
		try {
			return JdbcUtils.getQueryRunner()
					.query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

}
