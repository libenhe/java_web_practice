package school.libenhe.emp.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import school.libenhe.emp.dao.IEmpDao;
import school.libenhe.emp.entity.Emp;
import school.libenhe.emp.util.JdbcUtil;

public class EmpDao implements IEmpDao{

	@Override
	public void add(Emp emp) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into emps(id,username,salary,hiredate) values(?,?,?,?)";
		Object[] params = {emp.getId(),emp.getUsername(),emp.getSalary(),emp.getHiredate()};
		runner.update(sql,params);
		
	}

	
}
