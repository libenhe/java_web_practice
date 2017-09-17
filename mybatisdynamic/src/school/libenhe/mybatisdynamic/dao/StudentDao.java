package school.libenhe.mybatisdynamic.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import school.libenhe.mybatisdynamic.entity.Student;
import school.libenhe.mybatisdynamic.utils.MybatisUtil;

/**
 * 
 * @ClassName: StudentDao
 * @Description: 动态SQL操作
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-9-14 下午9:23:41
 * 
 */
public class StudentDao {

	/**
	 * 查询所有
	 * 
	 * @param id
	 *            ID编号
	 * @param name
	 *            姓名
	 * @param sal
	 *            薪水
	 * @return
	 * @throws Exception
	 */
	public List<Student> findAll(Integer id, String name, Double sal)
			throws Exception {

		SqlSession sqlSession = null;

		try {
			sqlSession = MybatisUtil.getSqlSession();

			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("pid", id);
			map.put("pname", name);
			map.put("psal", sal);

			return sqlSession.selectList("studentNamesapce.findAll", map);
		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {
			MybatisUtil.closeSqlSession();
		}

	}

	/**
	 * 根据条件动态更新
	 * 
	 * @param id
	 * @param name
	 * @param sal
	 * @throws Exception
	 */
	public void update(Integer id, String name, Double sal) throws Exception {
		SqlSession sqlSession = null;

		try {
			sqlSession = MybatisUtil.getSqlSession();

			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("pid", id);
			map.put("pname", name);
			map.put("psal", sal);

			sqlSession.update("studentNamesapce.update", map);
		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {
			MybatisUtil.closeSqlSession();
		}

	}
	/**
	 * 动态批量删除
	 * @param ids
	 * @throws Exception
	 */
	public void deletList(List<Integer> ids) throws Exception {
		SqlSession sqlSession = null;

		try {
			sqlSession = MybatisUtil.getSqlSession();

		sqlSession.delete("studentNamesapce.deleteList", ids);
		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {
			MybatisUtil.closeSqlSession();
		}
	}

	
	
	
	
	
	
	
	
	
	
	/**
	 * 动态查询所有测试
	 * 
	 * @throws Exception
	 */
	/**
	 * @Test public void findAllTest() throws Exception { StudentDao studentDao
	 *       = new StudentDao(); List<Student> list =
	 *       studentDao.findAll(null,"金三胖" , null); for (Student student : list)
	 *       { System.out.println(student.getId() +"_"+
	 *       student.getName()+": 薪水为"+ student.getSal()+"元。"); } }
	 */

	/**
	 * 动态根据id更新测试
	 * 
	 * @throws Exception
	 */
	
	    @Test 
	 public void updateTest() throws Exception {
	    StudentDao studentDao =new StudentDao(); 
	    	studentDao.update(1, "战斗民族", null); 
	    	}
	 
	 /**
	 * 动态批量删除测试
	 * @throws Exception
	 */
	@Test
	public void deleteTest() throws Exception {
		StudentDao dao = new StudentDao();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(4);
		ids.add(6);
		ids.add(8);
		dao.deletList(ids);
	}
}
