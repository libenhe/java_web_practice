package shool.libenhe.dao;

import java.util.List;

import shool.libenhe.entity.Employee;

/**
 * 
 * @ClassName: IEmployee 
 * @Description: 员工模块接口设计
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-25 下午8:30:01
 *
 */
public interface IEmployeeDao {

	/**
	 * 保存员工
	 * @param emp
	 */
	void save(Employee emp);
	/**
	 * 更新员工信息
	 * @param emp
	 */
	void update(Employee emp);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	void delete(int id);
	
	/**
	 *  根据主键查询
	 * @param id
	 * @return 查询结果
	 */
	Employee findById(int id);
	
	/**
	 *  查询全部
	 * @return 查询结果.0
	 */
	List<Employee> getAll();
	/**
	 * 根据员工名称条件查询
	 * @param employeeName
	 * @return 查询结果
	 */
	List<Employee> getAll(String employeeName);
}
