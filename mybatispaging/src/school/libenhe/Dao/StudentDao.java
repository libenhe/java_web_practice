package school.libenhe.Dao;

import org.apache.ibatis.session.SqlSession;

import school.libenhe.entity.Student;
import school.libenhe.utils.MybatisUtil;
/**
 * 
 * @ClassName: StudentDao 
 * @Description: 閹镐椒绠欑仦锟� * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-9-12 娑撳宕�:52:04
 *
 */
public class StudentDao {

	//婢х偛濮炵�锔炬晸
	public void add(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			//娴滃濮熷锟筋瀶閿涘牓绮拋銈忕礆
			//鐠囪褰嘢tudentMapper.xml閺勭姴鐨犻弬鍥︽娑擃厾娈慡QL鐠囶厼褰�
			sqlSession.insert(Student.class.getName()+".add",student);
			//娴滃濮熼幓鎰唉
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//娴滃濮熼崶鐐寸泊
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}


	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		
		dao.add(new Student(9,"fuli",9889.99));
		
	}
}
