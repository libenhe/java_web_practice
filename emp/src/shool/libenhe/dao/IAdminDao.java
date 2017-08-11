package shool.libenhe.dao;

import shool.libenhe.entity.Admin;

/***
 * 
 * @ClassName: IAdminDao 
 * @Description: 管理员接口
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-25 下午8:21:26
 *
 */
public interface IAdminDao {


    /***
     * 
     * @param admin 管理员对象
     */
	void save(Admin admin);
	
	/***
	 * 根据管理员信息查询
	 * @param admin 管理员对象
	 * @return 查询后结果
	 */
	Admin findByAdmin(Admin admin);
}
