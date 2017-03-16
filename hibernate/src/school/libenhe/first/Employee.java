package school.libenhe.first;

import java.util.Date;

/**
 * 对象
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-3-16 下午9:02:14
 */
public class Employee {

	private int empId;
	private String empName;
	private Date workDate;
	
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
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", workDate=" + workDate + "]";
	}
}
