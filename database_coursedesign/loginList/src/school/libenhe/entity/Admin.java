package school.libenhe.entity;
/**
 * 管理员实体类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-3 下午10:31:51
 */
public class Admin {

	private int id; 
	private String userName;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
