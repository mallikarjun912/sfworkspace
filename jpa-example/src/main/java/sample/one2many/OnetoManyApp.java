package sample.one2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OnetoManyApp {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Employee employee = new Employee();
		employee.setEmpName("Gavin King"); 
		
		Vehicles vehicle1 = new Vehicles();
		vehicle1.setRegno("TSAB12");
		vehicle1.setType("Two wheeler");
		vehicle1.setModel(2020);
	    vehicle1.setEmployee(employee); 
		
		Vehicles vehicle2 = new Vehicles();
		vehicle2.setRegno("TSGJ45");
		vehicle2.setType("Lite vehicle");
		vehicle2.setModel(2022);
		vehicle2.setEmployee(employee); 
		
		List<Vehicles> list = new ArrayList<Vehicles>();
		list.add(vehicle1);
		list.add(vehicle2);
		
		employee.setVehicles(list); 
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

}
