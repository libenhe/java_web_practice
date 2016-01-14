package school.libenhe.contactSystem_web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoImpl;
import school.libenhe.contactSystem_web.entity.Contact;
import school.libenhe.contactSystem_web.exception.NameRepeatException;
import school.libenhe.contactSystem_web.service.ContactService;
import school.libenhe.contactSystem_web.service.impl.ContactServiceImpl;

/**
 * 添加联系人
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2015-12-30 上午11:14:34
 */
public class AddContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//接收参数	
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		/*
		 System.out.println(name);//调试
		*/
		//封装成Contact对象
		Contact contact = new Contact();
		contact.setName(name);
		contact.setGender(gender);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		
		//调用dao类的添加联系人的方法
		ContactService contactService = new ContactServiceImpl();
		
		try {
			contactService.addContact(contact);
		} catch (NameRepeatException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/addContact.jsp").forward(request, response);
			return;
		}
		
		//跳转到查询联系人的页面
		response.sendRedirect(request.getContextPath()+"/ListContactServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
