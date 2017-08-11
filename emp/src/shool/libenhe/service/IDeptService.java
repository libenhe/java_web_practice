package shool.libenhe.service;

import java.util.List;

import shool.libenhe.entity.Dept;

/**
 * 
 * @ClassName: IDeptService 
 * @Description: 部门业务逻辑模块接口
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-31 上午10:17:56
 *
 */
public interface IDeptService {

	/**
	 * 查询全部
	 * @return 返回全部信息
	 */
	List<Dept> getAll();

	/**
	 * 根据主键查询
	 * @param id 主键
	 * @return 返回查询后结果
	 */
	Dept findById(int id);
}
