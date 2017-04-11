package school.libenhe.oneTwoMany;
/**
 * 
 * @ClassName: Employee 
 * @Description: 员工类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-4 下午8:06:16
 *
 */
public class Employee {
	
	private int empId;
	private String empName;
	private double salary;
	
	//（多对一）员工与部门
	private Dept dept;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	} 
	
	
}
