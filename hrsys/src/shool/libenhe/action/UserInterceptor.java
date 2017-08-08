package shool.libenhe.action;

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
public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		return null;
	}

	
	
}
