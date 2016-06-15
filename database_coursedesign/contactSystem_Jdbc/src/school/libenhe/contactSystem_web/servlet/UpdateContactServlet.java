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
* 修改联系人
* 
* @project_name：contactSystem_web
* @type_name：UpdateContactServlet
* @author：LiBenhe   E-mail：libenhe919@163.com
* @version： 2015-12-31 上午9:37:02
*
*/
public class UpdateContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		//接收参数	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		String edu = request.getParameter("edu");
		String pchange = request.getParameter("pchange");
		/**
		*System.out.println("名是："+ name);//调试
		*/
		System.out.println("名是："+ edu);
		//封装成Contact对象
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setGender(gender);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		contact.setEdu(edu);
		contact.setPchange(pchange);
		
		//测试调试
		System.out.println(contact.toString());
		
		//调用ContactDao修改
		ContactService contactService = new ContactServiceImpl();
		contactService.updateContact(contact);
		
		//重定向到查询所有联系人
		response.sendRedirect(request.getContextPath() + "/ListContactServlet");

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
