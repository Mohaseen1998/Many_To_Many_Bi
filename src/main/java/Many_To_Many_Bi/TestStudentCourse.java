package Many_To_Many_Bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		
		Course c = new Course();
		c.setName("Java");
		c.setDuration(6);

		Course c1 = new Course();
		c1.setName("pyton");
		c1.setDuration(5);

		Course c2 = new Course();
		c2.setName("react");
		c2.setDuration(6);

		List<Course> cour1 = new ArrayList<Course>();
		cour1.add(c);
		cour1.add(c2);
		
		List <Course> cour2 = new ArrayList<Course>();
		cour2.add(c);
		cour2.add(c1);
		cour2.add(c2);
		
		List<Course> cour3 = new ArrayList<Course>();
		cour3.add(c);
		cour3.add(c1);
		
		Student s = new Student();
		s.setAge(23);
		s.setName("Mohaseen");
		s.setCourses(cour1);

		Student s1 = new Student();
		s1.setAge(26);
		s1.setName("akshata");
		s1.setCourses(cour2);
		
		Student s2 = new Student();
		s2.setAge(23);
		s2.setName("hema");
		s2.setCourses(cour3);

		

		List <Student> stu1 = new ArrayList<Student>();
		stu1.add(s1);
		stu1.add(s);
		stu1.add(s2);
		

		List <Student> stu2 = new ArrayList<Student>();
		stu2.add(s);
		stu2.add(s2);
		

		List <Student> stu3 = new ArrayList<Student>();
		stu3.add(s1);
		stu3.add(s2);
		
		c.setStu(stu1);
		c1.setStu(stu2);
		c2.setStu(stu3);

		
		et.begin();
		em.persist(c);
		em.persist(c1);
		em.persist(c2);
		em.persist(s);
		em.persist(s1);
		em.persist(s2);
		et.commit();
		

	}
}
