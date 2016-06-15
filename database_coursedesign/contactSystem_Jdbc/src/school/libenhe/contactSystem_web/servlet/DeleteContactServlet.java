package school.libenhe.contactSystem_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.contactSystem_web.dao.ContactDao;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoImpl;
import school.libenhe.contactSystem_web.dao.impl.ContactDaoMYSQLImpl;
import school.libenhe.contactSystem_web.service.ContactService;
import school.libenhe.contactSystem_web.service.impl.ContactServiceImpl;


/**
* 删除联系人
*
* @project_name：contactSystem_web
* @type_name：DeleteContactServlet
* @author：LiBenhe   E-mail：libenhe919@163.com
* @version： 2015-12-31 上午9:37:49
*
*/
public class DeleteContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			//测试，火狐传递参数会传递两次，修改：在ContactDaoImpl删除方法中判断是否为null再进行删除，防止空指针
			/*System.out.println("删除联系人执行");//调试
			 * 
			 * */
			String id = request.getParameter("id");
	        //删除联系人
		ContactService contactService = new ContactServiceImpl();
			contactService.deleteContact(id);
			//跳转，重定向会到查看所有联系人
			response.sendRedirect(request.getContextPath()+"/ListContactServlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
