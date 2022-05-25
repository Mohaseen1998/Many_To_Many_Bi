package Many_To_Many_Bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestPersonCab {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Cab c = new Cab();
		c.setDrname("tulla");
		c.setCost(200.0);

		Cab c1 = new Cab();
		c1.setDrname("herma");
		c1.setCost(350);

		Cab c2 = new Cab();
		c2.setDrname("azahu");
		c2.setCost(250);

		List<Cab> cab1 = new ArrayList<Cab>();
		cab1.add(c);
		cab1.add(c1);
		cab1.add(c2);

		List<Cab> cab2 = new ArrayList<Cab>();
		cab2.add(c);
		cab2.add(c1);

		List<Cab> cab3 = new ArrayList<Cab>();
		cab3.add(c2);
		cab3.add(c1);

		Person p = new Person();
		p.setName("venki");
		p.setAge(23);
		p.setEmail("sgv@gmailcom");
		p.setCab(cab1);

		Person p1 = new Person();
		p1.setAge(25);
		p1.setEmail("xsha@gamil.com");
		p1.setName("hema");
		p1.setCab(cab2);

		List<Person> person = new ArrayList<Person>();
		person.add(p);

		List<Person> person1 = new ArrayList<Person>();
		person1.add(p);
		person1.add(p1);

		c.setPerson(person1);
		c1.setPerson(person);

		et.begin();
		em.persist(p1);
		em.persist(p);
		em.persist(c);
		em.persist(c2);
		em.persist(c1);
		et.commit();



	}

}
