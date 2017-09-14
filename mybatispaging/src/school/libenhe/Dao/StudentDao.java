package school.libenhe.Dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import school.libenhe.entity.Student;
import school.libenhe.utils.MybatisUtil;

public class StudentDao {

	/**
	 * 增加方法
	 * @param student
	 * @throws Exception
	 */
	public void add(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.insert(Student.class.getName()+".add",student);
			
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}

	/**
	 * 无条件分页
	 * @param star 从数据库第几条数据开始显示
	 * @param size 显示几条数据
	 * @return
	 * @throws Exception
	 */
	public List<Student> findAllPaging(int start, int size) throws Exception{
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MybatisUtil.getSqlSession();
			
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("mstart", start);
			map.put("msize", size);
			
			return sqlSession.selectList(Student.class.getName()+ ".findAllPaging", map);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			MybatisUtil.closeSqlSession();
		}
		
	}
	
	
	
	/**
	 * 有条件分页
	 * @param name 按照名字分页
	 * @param start 从第几条开始
	 * @param size 显示几条数据
	 * @return
	 * @throws Exception
	 */
	
	public List<Student> findAllNamePaging(String name, int start, int size) throws Exception{
		
	    	SqlSession sqlSession = null;
		
		try {
			sqlSession = MybatisUtil.getSqlSession();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			
			map.put("mname", "%"+name+"%");
			map.put("mstart", start);
			map.put("msize", size);
			return sqlSession.selectList(Student.class.getName() + ".findAllNamePaging", map); 
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closeSqlSession();
		}
		
	}
	
	
	
	
	/**
	 * 增加测试
	 * @throws Exception
	 */
	
	@Test
	public void saveTest() throws Exception{
	   StudentDao dao = new StudentDao();
		
		dao.add(new Student(17,"金2胖", 222.99));
		
	}

	
	/**
	 * 无条件分页测试
	 * @throws Exception
	 */
	
	@Test
	public void findPagingTest() throws Exception{
	   StudentDao dao = new StudentDao();
		

		System.out.println("--------------------第一页");
		List<Student> studentList1 = dao.findAllPaging(0,5);
		for(Student s : studentList1){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		System.out.println("--------------------第二页");
		List<Student> studentList2 = dao.findAllPaging(5,5);
		for(Student s : studentList2){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		System.out.println("--------------------第三页");
		List<Student> studentList3 = dao.findAllPaging(10,5);
		for(Student s : studentList3){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		
	}
	
	
	
	/**
	 * 有条件分页测试
	 * @throws Exception
	 */
	
	@Test
	public void findAllNamePagingTest() throws Exception{
	   StudentDao dao = new StudentDao();
		

		System.out.println("--------------------第一页");
		List<Student> studentList1 = dao.findAllNamePaging("金",0,15);
		for(Student s : studentList1){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		System.out.println("--------------------第二页");
		List<Student> studentList2 = dao.findAllNamePaging("普", 0,15);
		for(Student s : studentList2){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		System.out.println("--------------------第三页");
		List<Student> studentList3 = dao.findAllNamePaging("牛", 0,15);
		for(Student s : studentList3){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		
	}

	


}
