package school.libenhe.contactSystem_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
* 修改之前查询要修改的联系人逻辑
* 
* @project_name：contactSystem_web
* @type_name：QueryContactServlet
* @author：LiBenhe   E-mail：libenhe919@163.com
* @version： 2015-12-31 上午9:36:46
*
*/
public class QueryContactServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			//接受id值
			String id = request.getParameter("id");
			//根据id查询联系人
			ContactService contactService = new ContactServiceImpl();
			Contact contact = contactService.findById(id);
			
			request.setAttribute("contact", contact);
			
			request.getRequestDispatcher("/updateContact.jsp").forward(request, response);
			
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}









