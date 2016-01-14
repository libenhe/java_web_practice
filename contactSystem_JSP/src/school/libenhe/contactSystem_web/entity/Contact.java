package school.libenhe.contactSystem_web.entity;

/**
 * Contact联系人实体对象
 * 
 * @project_name：contactSystem_web
 * @type_name：Contact
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-29 下午12:52:07
 * 
 */
public class Contact {

	private String id;
	private String name;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private String qq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
	public String toString() {
		return "Contact [age=" + age + ", email=" + email + ", gender="
				+ gender + ", id=" + id + ", name=" + name + ", phone=" + phone
				+ ", qq=" + qq + "]";
	}
 
}
