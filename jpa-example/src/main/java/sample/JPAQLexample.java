package sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAQLexample {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("salesforce");
		EntityManager manager = factory.createEntityManager();
		
		// to get the single object
		Student std = manager.find(Student.class, 301);
		System.out.println(std);  
		//JPA QL
		Query qry1 = manager.createQuery("from Student");
		Query qry2 = manager.createQuery("select std from Student std where std.rno<?1");
		Query qry3 = manager.createQuery("select std from Student std where std.total between :first and :second");
		Query qry4 = manager.createQuery("select std from Student std where std.studentName like :str");
		qry3.setParameter("first", 300);
		qry3.setParameter("second", 400);
		qry4.setParameter("str", "%a%");
		List<Student> stdlist = qry4.getResultList();
		for(Student s : stdlist)
			System.out.println(s);  
		
		// named query
		System.out.println("named query");
		Query namedQuery = manager.createNamedQuery("findAll");
		 stdlist = namedQuery.getResultList();
		for(Student s : stdlist)
			System.out.println(s);  
		
		//native sql 
		System.out.println("native query ");
		Query nativeSql = manager.createNativeQuery("select * from student", Student.class);
		List<Student> nativeList = nativeSql.getResultList();
		for(Student student : nativeList)
			System.out.println(student);
		
		nativeSql = manager.createNativeQuery("select rno,studentName from student");
		List<Object[]> objects = nativeSql.getResultList();
		int rno;
		String name;
		for(Object[] obj : objects) {
			rno = (int) obj[0];
			name = (String) obj[1];
			System.out.println(rno+" "+name);  
		}
	}

}
