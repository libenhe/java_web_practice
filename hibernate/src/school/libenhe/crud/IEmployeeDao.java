package school.libenhe.crud;

import java.io.Serializable;
import java.util.List;

import school.libenhe.first.Employee;

/**
 * 
 * @ClassName: IEmployeeDao 
 * @Description: CRUD操作接口
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-3-24 上午10:10:37
 *
 */
public interface IEmployeeDao {
    
	void save(Employee emp);
	void update(Employee emp);
	Employee findById(Serializable id);
	List<Employee> getAll();
	List<Employee> getAll(String employeeName);
	List<Employee> getAll(int index, int count);
	void delete(Serializable id);
}
