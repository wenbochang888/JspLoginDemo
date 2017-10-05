package test;

import java.util.List;

import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.po.Customer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		CustomerDAO c = new CustomerDAOImpl();
//		
//		
//		Customer c2 = new Customer();
//		c2.setSno("15251102180");
//		c2.setSname("lisi");
//		c2.setPhone("13125457854");
//		c.save(c2);
		List<Customer> students = c.getAllInformation();
//		for (Customer c1 : students) {
//			System.out.println(c1.getSno() + "  " + c1.getSname() + "  " + c1.getPhone());
//		}
//		System.out.println("-------------");
//		c.delete("15251102180");
//		students = c.getAllInformation();
		for (Customer c1 : students) {
			System.out.println(c1.getSno() + "  " + c1.getSname() + "  " + c1.getPhone());
		}
		System.out.println(c.getCountWithName("ABC"));
	}
}
