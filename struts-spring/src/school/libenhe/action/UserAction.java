package school.libenhe.action;

import school.libenhe.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private UserService userService;



	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() {
		userService.save();
		return SUCCESS;
	}
}
