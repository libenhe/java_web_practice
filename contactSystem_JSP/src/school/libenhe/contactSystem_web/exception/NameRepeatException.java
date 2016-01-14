package school.libenhe.contactSystem_web.exception;
/**
 * 姓名重复的自定义异常类
 * 
 * @author：LiBenhe E-mail：libenhe919@163.com
 * @version： 2016-1-14 上午10:25:59
 */
public class NameRepeatException extends Exception{
	
	public NameRepeatException(String msg) {
			super(msg);
	}
}
