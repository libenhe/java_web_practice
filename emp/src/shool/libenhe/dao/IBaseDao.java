package shool.libenhe.dao;

import java.util.List;

/**
 * 
 * @ClassName: IBaseDao 
 * @Description: 所有的dao通用接口在此类定义
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-8 下午4:16:02
 *
 */
public interface IBaseDao<T> {

	/**
	 * 保存
	 * @param t
	 */
	void save(T t);
	/**
	 * 更新对象信息
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	void delete(int id);

	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	T findById(int id);
	
	/**
	 * 查询全部
	 * @return
	 */
	List<T> getAll();
	
	
}
