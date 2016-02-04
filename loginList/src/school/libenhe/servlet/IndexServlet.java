package school.libenhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.entity.Employee;
import school.libenhe.service.IEmployeeService;
import school.libenhe.service.impl.EmployeeService;

/**
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-4 下午12:35:21
 */
public class IndexServlet extends HttpServlet {

	private IEmployeeService employeeService = new EmployeeService();

	private String url;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; cahrset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		List<Employee> list = employeeService.getAll();
		
		request.setAttribute("listEmp", list);
		
		//进入jsp页面
		
		url = "/list.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
