package sample.one2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetOne2ONe {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		
		Person person = manager.find(Person.class, 2);
		System.out.println(person.getPersonId()+person.getPersonName());
		
		Passport passport = manager.find(Passport.class, "G123456");
		System.out.println(passport.getPassportNumber()+passport.getDateIssued());
		System.out.println(passport.getPerson().getPersonId()); 

	}

}
