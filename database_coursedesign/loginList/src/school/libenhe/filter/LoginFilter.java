package school.libenhe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 管理员登陆过滤器类 indexServlet, lisy.jsp需要过滤不能直接访问
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-2-6 下午7:26:39
 */
public class LoginFilter implements Filter{

	private String uri;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//0. 转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//1. 获取请求资源，截取  
		String uri = request.getRequestURI();   // /emp_sys/login.jsp
		// 截取 【login.jsp或login】
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());  
		
		//2. 判断： 先放行一些资源：/login.jsp、/login
		if ("loginServlet".equals(requestPath) || "Login.jsp".equals(requestPath)) {
			// 放行
			chain.doFilter(request, response);
		}
		else {
			//3. 对其他资源进行拦截
			//3.1 先获取Session、获取session中的登陆用户(loginInfo)
			HttpSession session = request.getSession(false);
			// 判断
			if (session != null) {
				
				Object obj = session.getAttribute("loginInfo");
				
				//3.2如果获取的内容不为空，说明已经登陆，放行
				if (obj != null) {
					// 放行
					chain.doFilter(request, response);   
					return;
				} else {
					//3.3如果获取的内容为空，说明没有登陆； 跳转到登陆
					uri = "/Login.jsp";
				}
				
			} else {
				// 肯定没有登陆
				uri = "/Login.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
