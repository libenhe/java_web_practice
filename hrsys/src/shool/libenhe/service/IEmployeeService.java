package shool.libenhe.service;

import java.util.List;

import shool.libenhe.entity.Employee;

/**
 *   
 * @ClassName: IEmployeeService 
 * @Description: 员工业务逻辑接口
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-31 上午10:32:05
 *
 */
public interface IEmployeeService {

	/**
	 * 根据主键删除
	 * @param id
	 */
	void delete(int id);
	/**
	 * 保存员工
	 * @param emp
	 */
	void save(Employee emp);
	
	/**
	 * 跟新新员工数据
	 * @param emp
	 */
	void update(Employee emp);
	
	/**
	 *  根据主键查询
	 * @param id
	 * @return
	 */
	Employee findById(int id);
	/**
	 * 查询全部
	 * @return 查询结果
	 */
	List<Employee> getAll();
	
	/**
	 * 根据员工姓名查询
	 * @param employeeName 员工姓名
	 * @return
	 */
	List<Employee> getAll(String employeeName);
	/**
	 * 删除多个员工
	 * @param ids
	 */
	void deleteMany(int[] ids);
}
