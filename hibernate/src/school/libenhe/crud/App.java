package school.libenhe.crud;

import org.junit.Test;

import school.libenhe.first.Employee;

public class App {

	private EmployeeDaoImpl empDaoImpl = new EmployeeDaoImpl();
	
	@Test
	public void testFindById() {
		System.out.println(empDaoImpl.findById(1));
	}
	
	@Test
	public void testGetAll() {
		System.out.println(empDaoImpl.getAll());
	}
	
	@Test
	public void testGetAllString() {
		System.out.println(empDaoImpl.getAll("李本贺"));
	}
	@Test
	public void testGetAllIntInt() {
		System.out.println(empDaoImpl.getAll(4,2));
	}
	
	@Test
	public void tsetSave() {
		empDaoImpl.save(new Employee());
	}
	
	@Test
	public void testUpdate() {
		Employee emp = new Employee();
		emp.setEmpId(22);
		emp.setEmpName("libenhe");
		empDaoImpl.update(emp);
	}
	
	@Test
	public void testDelete() {
		empDaoImpl.delete(22);
	}
	
}
