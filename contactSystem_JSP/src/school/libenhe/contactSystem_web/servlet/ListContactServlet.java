package school.libenhe.contactSystem_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoImpl;
import school.libenhe.contactSystem_web.entity.Contact;
import school.libenhe.contactSystem_web.service.ContactService;
import school.libenhe.contactSystem_web.service.impl.ContactServiceImpl;

/**
 * 查询所有联系人的逻辑Servlet主页
 * 
 * @project_name：contactSystem_web
 * @type_name：ListContactServlet
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-31 上午9:37:16
 * 
 */
public class ListContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 从XML中读取联系人信息
		ContactService contactService = new ContactServiceImpl();
		List<Contact> list = contactService.findAll();

		// 储存到域对象中
		request.setAttribute("contacts", list);
		// 转发到JSP页面
		request.getRequestDispatcher("/listContact.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
