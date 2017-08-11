package shool.libenhe.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @ClassName: UserInterceptor
 * @Description: 有效管理员可以登录，登陆之后才可以进行操作
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-8 下午8:51:12
 * 
 */
public class UserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 得到当前执行的方法
		String methodName = invocation.getProxy().getMethod();
		// 得到ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		// 获取session, 从session中获取登陆的管理员账号
		Object obj = ac.getSession().get("adminInfo");
		// 判断
		if (!"login".equals(methodName) && !"list".equals(methodName)) {
			if (obj == null) {
				// 没有登陆
				return "login";
			} else
				// 执行Action
				return invocation.invoke();

		} else {
			// 允许访问登陆、列表展示
			return invocation.invoke();
		}

	}
}
