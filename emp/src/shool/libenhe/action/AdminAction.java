package shool.libenhe.action;

import shool.libenhe.entity.Admin;
import shool.libenhe.service.IAdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @ClassName: AdminAction
 * @Description: 管理员登陆注册模块
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-8 下午4:46:23
 * 
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	// 封装请求数据
	private Admin admin = new Admin();

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	@Override
	public Admin getModel() {
		return admin;
	}

	private IAdminService adminService;

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public String login() {
		Admin adminInfo = adminService.login(admin);
		if (adminInfo == null) {
			// 登陆失败
			return "loginFaild";
		} else {
			// 登陆成功, 保存数据到session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
