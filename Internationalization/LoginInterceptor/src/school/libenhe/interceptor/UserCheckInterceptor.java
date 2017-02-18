package school.libenhe.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2017-2-11 下午10:11:44
 */
public class UserCheckInterceptor extends AbstractInterceptor{

	/**
	 * 拦截器处理
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		/**
		 * 拿到当前执行的方法名，只要当前的方法名不是login，就进行验证
		 */
		
		//获取ActionContext对象
		ActionContext actionContext = invocation.getInvocationContext();
		
		//获取action的代理对象
		ActionProxy actionProxy = invocation.getProxy();
		
		//获取当前执行的方法名
		
		String methodName = actionProxy.getMethod();
		
		//判断
		if (!"login".equals(methodName)) {
			//获取当前登录的用户
				Object object = actionContext.getSession().get("userInfo");
			if (object == null) {
				//没有登陆
				return"input";
			} else {
				// 已经登陆
				return invocation.invoke();
			} 
		} else {
			return invocation.invoke();
		}
		
	}

}










