package sample.one2one;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToOneMain {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Person person = new Person();
		person.setPersonName("Gavin king");
		
		Passport passport = new Passport();
		passport.setPassportNumber("G456789");
		passport.setDateIssued(new Date()); 
		passport.setPerson(person); 
		transaction.begin();
		manager.persist(passport); 
		transaction.commit();

	}

}
