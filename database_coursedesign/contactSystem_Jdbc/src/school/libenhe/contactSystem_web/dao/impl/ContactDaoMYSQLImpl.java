package school.libenhe.contactSystem_web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.entity.Contact;
import school.libenhe.contactSystem_web.util.JdbcUtil;

/**
 * Contact接口实现类（mysql）
 * 
 * @project_name：contactSystem_Jdbc
 * @type_name：ContactDaoMYSQLImpl
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-22 下午7:15:53
 * 
 */
public class ContactDaoMYSQLImpl implements ContactDao {


	/**
	 * 添加联系人
	 */
	public void addContact(Contact contact) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO contact(id,NAME,gender,age,phone,email,qq,edu,pchange) VALUES(?,?,?,?,?,?,?,?,?)";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			String id = UUID.randomUUID().toString().replace("-", "");
			//设置参数	
			stmt.setString(1, id);
			stmt.setString(2, contact.getName());
			stmt.setString(3, contact.getGender());
			stmt.setInt(4, contact.getAge());
			stmt.setString(5, contact.getPhone());
			stmt.setString(6, contact.getEmail());
			stmt.setString(7, contact.getQq());
			stmt.setString(8, contact.getEdu());
			stmt.setString(9, contact.getPchange());
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}

	public boolean checkContact(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM contact where name=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, name);
	
			//执行
			rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}

	public void deleteContact(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "DELETE FROM contact WHERE id=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//设置参数
			stmt.setString(1, id);
			
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}

	public List<Contact> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM contact";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
	
			//执行
			rs = stmt.executeQuery();
			List<Contact> list = new ArrayList<Contact>();
			while(rs.next()){
				Contact c = new Contact();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setAge(rs.getInt("age"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setQq(rs.getString("qq"));
				c.setEdu(rs.getString("edu"));
				c.setPchange(rs.getString("pchange"));
				list.add(c);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}

	public Contact findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM contact where id=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
	
			//执行
			rs = stmt.executeQuery();
			Contact c = null;
			if(rs.next()){
				c = new Contact();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setAge(rs.getInt("age"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setQq(rs.getString("qq"));
				c.setEdu(rs.getString("edu"));
				c.setPchange(rs.getString("pchange"));
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}

	/**
	 * 修改
	 */
	public void updateContact(Contact contact) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "UPDATE contact SET NAME=?,gender=?,age=?,phone=?,email=?,qq=?,edu=?,pchange=? WHERE id=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			//设置参数
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getGender());
			stmt.setInt(3, contact.getAge());
			stmt.setString(4, contact.getPhone());
			stmt.setString(5, contact.getEmail());
			stmt.setString(6, contact.getQq());
			stmt.setString(7, contact.getEdu());
			stmt.setString(8, contact.getPchange());
			stmt.setString(9, contact.getId());
			
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}

	}

}
