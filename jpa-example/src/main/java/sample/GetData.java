package sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetData {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		//To get the single object
		
		Student student = manager.find(Student.class, 141);
		System.out.println(student);  
		
		Query query = manager.createQuery("from Student");
		List<Student> stdList = query.getResultList();
		for(Student std : stdList) 
			System.out.println(std.getRno()+ " "+std.getStudentName()+" "+std.getTotal());  
		
	}

}
