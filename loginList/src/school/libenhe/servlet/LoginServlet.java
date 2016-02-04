package school.libenhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("nserName");
		String pwd = request.getParameter("pwd");
		
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		
		Admin loginInfo = adminService.findByName(admin);
		
		if (loginInfo == null) {
			//登陆失败
			url = "/Login.jsp";
		} else {
			
			request.getSession().setAttribute("loginInfo",loginInfo);
			
			url = "/index";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
