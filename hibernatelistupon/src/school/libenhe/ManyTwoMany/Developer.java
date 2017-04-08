package school.libenhe.ManyTwoMany;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: Developer 
 * @Description: 多对多映射案例 员工类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-8 下午4:17:42
 *
 */
public class Developer {

	private int  devId;
	private int  devName;
	
	// 开发人员，参数的多个项目
		private Set<Project> projects = new HashSet<Project>();
	
}






