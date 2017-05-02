package school.libenhe.query;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @ClassName: Dept 
 * @Description: 部门
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-5-2 下午7:58:24
 *
 */
public class Dept {
	
	private int deptId;
	private String deptName;
	// 部门对应的多个员工
	private Set<Employee> emps = new HashSet<Employee>();
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
}
