package school.libenhe.interceptor;

import org.hibernate.Session;

import school.libenhe.utils.HibernateUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 
 * @ClassName: SessionInterceptor 
 * @Description: Session管理拦截器，当访问action的时候，创建session
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-7-7 上午9:50:07
 *
 */
public class SessionInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		try {
			Session session = HibernateUtils.getSession();
			
			session.beginTransaction();
			
			String result = invocation.invoke();
			
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
		return "错误！";
		}
	}

}
