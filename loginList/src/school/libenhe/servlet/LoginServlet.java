package school.libenhe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.entity.Admin;
import school.libenhe.service.IAdminService;
import school.libenhe.service.impl.AdminService;

/**
 * login的Servlet
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-4 下午12:00:23
 */
public class LoginServlet extends HttpServlet {

	private IAdminService adminService = new AdminService();
	private String url;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		//测试
				System.out.println("888888888888888888：  "+userName);
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		
		
		try {
			Admin loginInfo = adminService.findByName(admin);
			
			if (loginInfo == null) {
				//登陆失败
				url = "/Login.jsp";
			} else {
				
				request.getSession().setAttribute("loginInfo", loginInfo);
				
				url = "/indexServlet";
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			url = "/error/error.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
