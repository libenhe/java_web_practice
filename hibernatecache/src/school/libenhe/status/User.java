package school.libenhe.status;
/***
 * 
 * @ClassName: User 
 * @Description: 实体类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-16 下午7:41:02
 *
 */
public class User {

	private int userId;
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}

}
