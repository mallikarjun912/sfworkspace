package sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateAndDelete {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		//update 
		Student std = manager.find(Student.class, 346);
		std.setTotal(900);
		transaction.begin();
		manager.persist(std);
		//manager.remove(std); 
		transaction.commit();
	}

}
