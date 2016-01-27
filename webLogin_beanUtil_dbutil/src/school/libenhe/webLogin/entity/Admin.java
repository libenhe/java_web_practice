package school.libenhe.webLogin.entity;

/**
 * 实体类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午7:19:21
 */
public class Admin {

	private int id;
	private String userName;
	private String passWord;

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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
