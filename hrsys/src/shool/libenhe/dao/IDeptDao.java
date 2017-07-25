package shool.libenhe.dao;

import java.util.List;

import shool.libenhe.entity.Dept;

/**
 * 
 * @ClassName: IDeptDao 
 * @Description: 部门模块接口设计
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-25 下午8:25:03
 *
 */
public interface IDeptDao {

	/**
	 * 查询全部
	 * @return 全部信息
	 */
	List<Dept> getAll();
	/**
	 * 根据主键查询
	 * @param id 主键
	 * @return 查询后结果
	 */
	Dept findById(int id);
}











