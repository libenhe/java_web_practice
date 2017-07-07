package school.libenhe.action;

import school.libenhe.entity.Dept;
import school.libenhe.service.DeptService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeptAction extends ActionSupport{

	private DeptService deptService = new DeptService();
	
	public String execute() {
		//主键查询
		Dept dept = deptService.findById(5);//随便模拟个数据
		//保存
		ActionContext.getContext().getContextMap().put("dept", dept);
		
		return SUCCESS;
	}
}
