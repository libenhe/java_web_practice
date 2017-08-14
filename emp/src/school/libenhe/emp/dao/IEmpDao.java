package school.libenhe.emp.dao;

import school.libenhe.emp.entity.Emp;

public interface IEmpDao {

	/**
	 * 增加员工
	 * @param emp
	 * @throws Exception 
	 */
	void add(Emp emp) throws Exception;
}
