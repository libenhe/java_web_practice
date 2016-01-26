package school.libenhe.webLogin.servlet;

import java.io.IOException;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.webLogin.entity.Admin;
import school.libenhe.webLogin.exception.UserExistException;
import school.libenhe.webLogin.service.IAdminService;
import school.libenhe.webLogin.service.Impl.AdminService;

/**
 * servlet控制层
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-25 下午9:29:54
 */
public class AdminServlet extends HttpServlet {
	
	private IAdminService adminService = new AdminService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if ("register".equals(method)) {
			register(request, response);
		}
		
		if ("login".equals(method)) {
			Login(request, response);
		}
	}

	
	/**
	 * 登陆的处理方法
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-26 下午12:44:39
	 * @param request
	 * @param response
	 */
	private void Login(HttpServletRequest request, HttpServletResponse response) {

	}


	/**
	 * 注册处理方法
	 * 
	 * @author：LiBenhe  E-mail：libenhe919@163.com
	 * @version： 2016-1-25 下午9:42:07
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		//1. 获取请求参数
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		// 封装
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPassWord(pwd);
		
		//2. 调用Service处理注册的业务逻辑
		try {
			adminService.register(admin);
			
			// 注册成功，跳转到首页
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (UserExistException e) {
			// 用户名存在，注册失败(跳转到注册页面)
			request.setAttribute("message", "用户名已经存在");
			// 转发
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();  // 测试时候用
			// 其他错误, 跳转到错误页面
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
