package school.libenhe.onetoone2;

public class IdCard {

	private int user_id;
	// 身份证号
	private String cardNum;//
	private String place; // 身份证地址
	// 身份证与用户，一对一的关系
	private User user;

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
