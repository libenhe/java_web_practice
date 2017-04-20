package school.libenhe.onetoone2;
/***
 * 
 * @ClassName: User 
 * @Description: 用户
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-18 下午3:26:43
 *
 */
public class User {

	private int userId;
	private String userName;
	// 用户与身份证信息， 一对一关系
	private IdCard idCard;
	
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
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	
}
