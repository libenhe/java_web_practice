package school.libenhe.dao;

import school.libenhe.entity.Dept;
import school.libenhe.utils.HibernateUtils;

public class DeptDao {

	// 根据主键查询
	public Dept findById(int id) {
		//获取到session，执行操作
		return (Dept) HibernateUtils.getSession().get(Dept.class, 1);
	}
}
