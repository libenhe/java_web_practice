package school.libenhe.webLogin.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 使用beanutil封装数据
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-26 下午9:34:15
 */
public class WebBeanUtil {

	@Deprecated
	public static <T> T copyToBean_old(HttpServletRequest request, Class<T> clazz) {
		
		try {
			T t = clazz.newInstance();
			
			Enumeration<String> enumeration =  request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String value = request.getParameter(name);
				BeanUtils.copyProperty(t, name, value);
			}
			return t;
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		
	}

	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		
		try {
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
		throw new RuntimeException(e);
		} 
	}
}
