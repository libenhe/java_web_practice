package school.libenhe.mybatis;
/**
 * 
 * @ClassName: Student 
 * @Description: 学生实体类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-24 下午9:23:55
 *
 */
public class Student {

	private Integer id;//编号
	private String name;//学生姓名
	private Double sal;//学生薪水
	public Student(){}
	public Student(Integer id, String name, Double sal) {
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	public Integer getId() {
		System.out.println("getId()");
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		System.out.println("getName()");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSal() {
		System.out.println("getSal()");
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
}
