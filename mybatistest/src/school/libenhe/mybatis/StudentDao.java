package school.libenhe.mybatis;

import org.apache.ibatis.session.SqlSession;

public class StudentDao {

	public void add(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			//事务开始（默认）
			//读取StudentMapper.xml映射文件中的SQL语句
			sqlSession.insert(Student.class.getName()+".add",student);
			//事务提交
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//事务回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	

	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		
		dao.add(new Student(4,"libenhe",8000.3));
		
	}
}
