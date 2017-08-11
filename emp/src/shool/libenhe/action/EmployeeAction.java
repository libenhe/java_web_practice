package shool.libenhe.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import shool.libenhe.entity.Dept;
import shool.libenhe.entity.Employee;
import shool.libenhe.service.IDeptService;
import shool.libenhe.service.IEmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee>, RequestAware {

	private Employee employee = new Employee();

	private int deptId;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getDeptId() {
		return deptId;
	}

	public Employee getModel() {
		return employee; // 返回实例化后对象
	}

	// 注入service
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private IDeptService deptService;

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	/**
	 * 员工列表展示
	 * 
	 * @return
	 */
	public String list() {
		List<Employee> listemp = employeeService.getAll();
		request.put("listEmp", listemp);
		return "list";
	}

	/**
	 * 添加员工： 进入添加界面
	 * 
	 * @return
	 */
	public String viewAdd() {
		// 查询所有部门信息, 保存到request
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	/**
	 * 添加员工数据
	 * @return
	 */
	public String save() {
		// 先根据部门主键查询
		Dept dept = deptService.findById(deptId);
		// 设置到员工对象中
		employee.setDept(dept);
		//调用Service保存员工
		employeeService.save(employee);
		return "listAction";
	}
	/**
	 * 修改员工信息： 进入修改视图
	 * @return
	 */
	public String viewUpDate() {
	int id = employee.getId();
	//根据员工的主键查询  (lazy="false")
	Employee emp = employeeService.findById(id);
	List<Dept> listDept = deptService.getAll();
	// 数据回显
	ValueStack vs = ActionContext.getContext().getValueStack();
	vs.pop();    // 移除栈顶元素
	vs.push(emp);// 入栈
	
	request.put("listDept", listDept);
		
		return "edit";
	}
	/**
	 * 修改员工信息 : 确认修改
	 * @return 返回到列表
	 */
	public String upDate() {
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.update(employee);
		
		return "listAction";
	}
	
	public String delete() {
		int empId = employee.getId();
		employeeService.delete(empId);
		return "listAction";
	}
	

	// 接收运行时传入的代表request对象的map
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
