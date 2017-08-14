package school.libenhe.emp.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import school.libenhe.emp.entity.Emp;
import school.libenhe.emp.service.EmpSrevice;

/**
 * 
 * @ClassName: EmpAction 
 * @Description: 控制器
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-8-14 下午4:15:02
 *
 */
@SuppressWarnings("deprecation")
public class EmpAction extends AbstractCommandController{

	private EmpSrevice empSrevice;
	public void setEmpSrevice(EmpSrevice empSrevice) {
		this.empSrevice = empSrevice;
	}
	
	//将表单参数封装到Emp实体中
	public EmpAction() {
		this.setCommandClass(Emp.class);
	}
	@Override
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(
				Date.class, 
				new CustomDateEditor(new SimpleDateFormat("dd-MM-yy"),true));
	}
	
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object obj, BindException erorr)
			throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		Emp emp = (Emp)obj;
		
		empSrevice.register(emp);
		modelAndView.addObject("message", "Success!");
		
		modelAndView.setViewName("success");
		return modelAndView;
	}

	
}
