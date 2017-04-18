package school.libenhe.onetoone;

public class IdCard {


	// 身份证号(主键)
	private String cardNum;// 对象唯一表示(Object Identified, OID)
	private String place; //  身份证地址
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
	
	
}
