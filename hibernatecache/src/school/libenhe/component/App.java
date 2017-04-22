package school.libenhe.component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 
 * @ClassName: App 
 * @Description: 组件映射测试类
 * @author Li Benhe Email: libenhe919@gmail.com
 * @date 2017-4-22 下午3:54:51
 *
 */
public class App {

	 private static SessionFactory sf;
	 
	 static {
		 sf = new Configuration()
		      .configure()
		      .addClass(Car.class)
		      .buildSessionFactory();
	 }
	
	 @Test
	 public void setSave() {
		 
		 Session session = sf.openSession();
		 session.beginTransaction();
		 
		 Wheel wheel = new Wheel();
		 wheel.setCount(4);
		 wheel.setSize(32);
		 
		 Car car = new Car();
		 car.setName("李本贺的普拉多");
		 car.setWheel(wheel);
		 
		 //保存
		 session.save(car);
		 
		 session.getTransaction().commit();
		 
		 session.close();
	 }
	 
	 
	
}







