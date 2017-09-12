package school.libenhe.utils;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private MybatisUtil(){}
	
	public static SqlSession getSqlSession(){
		
		SqlSession sqlSession = threadLocal.get();
		
		if(sqlSession == null){
			
			sqlSession = sqlSessionFactory.openSession();
			
			threadLocal.set(sqlSession);
		}
		
		return sqlSession;
	}
	
	public static void closeSqlSession(){
		
		SqlSession sqlSession = threadLocal.get();
	
		if(sqlSession != null){
			
			sqlSession.close();
			
			threadLocal.remove();
		}
	}
	
	//测试是否连接
	
	public static void main(String[] args) {
		Connection conn = MybatisUtil.getSqlSession().getConnection();
		System.out.println(conn!=null?"连接成功":"连接失败");
	}
}



