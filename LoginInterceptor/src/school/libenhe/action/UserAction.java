package school.libenhe.action;

import java.util.List;

import school.libenhe.entity.Admin;
import school.libenhe.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-2-11 下午4:06:17
 */
public class UserAction extends ActionSupport{

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	private AdminService adminService = new AdminService();
	
	//登陆
	public String login() {
		
		
			try {
				Admin userInfo = adminService.login(admin);
				//判断
				if (userInfo == null) {
					return "input";
				}
				//登陆成功数据保存在session中
				ActionContext.getContext().getSession().put("userInfo", userInfo);
				return "loginSuccess";
			} catch (Exception e) {
				return ERROR;
			}
			
	}
	
	//列表
	public String list() {
		try {
			List<Admin> list = adminService.getAll();
			//保存到request
			ActionContext.getContext().getContextMap().put("listAdmin", list);
			return "list";
		} catch (Exception e) {
			return ERROR;
		}
	}
}
