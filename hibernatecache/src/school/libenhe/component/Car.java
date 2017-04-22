package school.libenhe.component;
/**
 * 
 * @ClassName: Car 
 * @Description: 实体类，在此映射基础上加上组件映射
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-22 下午4:10:58
 *
 */
public class Car {

	private int id;
	private String name;
	//车轮
	private Wheel wheel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	
	
}
