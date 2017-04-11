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
	private String  devName;
	
	// 开发人员，参数的多个项目
    private Set<Project> projects = new HashSet<Project>();

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	    
		
}






