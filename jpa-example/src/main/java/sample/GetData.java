package sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetData {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		//To get the single object
		
		Student student = manager.find(Student.class, 141);
		System.out.println(student);  
		
		//Query query = manager.createQuery("from Student");
		Query query = manager.createNamedQuery("findAll");
		List<Student> stdList = query.getResultList();
		for(Student std : stdList) 
			System.out.println(std.getRno()+ " "+std.getStudentName()+" "+std.getTotal());  
		
		String qry = "select  std from Student std where std.rno<?1";
		String qry2 = "select std from Student std where std.studentName like ?1";
		String qry3 = "select std from Student std where std.total between ?1 and ?2";
		String qry4 = "select std from Student std where std.total between :first and :second";
		query = manager.createQuery(qry4);
		//query.setParameter(1, "%J%");
		query.setParameter("first", 400);
		query.setParameter("second", 700);
		stdList = query.getResultList();
		stdList.forEach((s)->System.out.println(s.getRno()+"  "+s.getStudentName()+" "+s.getTotal()));
		
		System.out.println("native query");
		Query nativeqry = manager.createNativeQuery("select * from student", Student.class);
		List<Student> nativeList = nativeqry.getResultList();
		nativeList.forEach((s)->System.out.println(s.getRno()+"  "+s.getStudentName()+" "+s.getTotal()));
		
	}

}
