package school.libenhe.ManyTwoMany;

import java.util.HashSet;
import java.util.Set;

/***
 * 
 * @ClassName: Project 
 * @Description: 多对多映射案例 项目类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-8 下午4:18:16
 *
 */
public class Project {

	private int proId;
	private String  proName;
	
	private Set<Developer> developers = new HashSet<Developer>();

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Set<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
	
	
}
