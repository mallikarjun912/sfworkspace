package sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddStudent {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Student student = new Student();
		student.setRno(451);
		student.setStudentName("Arjun");
		student.setTotal(550);
		
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		manager.close();
		
	}
}
