package intermediate_entity.app;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import intermediate_entity.Address;
import intermediate_entity.Discipline;
import intermediate_entity.Professor;
import intermediate_entity.Student;
import intermediate_entity.UniClass;

import hibernate.utils.HibernateUtil;

public class App {

	public static void main(String[] args) {
		App app = new App();

		app.insertion();    // insertion can also be done using insertion.txt file commands
                            // do not forget to update mapping class in hibernate.cfg.xml file
	}
	
	public void insertion() {
		
		Student student1 = new Student(111, "Edvaldo Carlos Silva", new Address("Av. Sao Carlos, 186", "Sao Carlos-SP"));
		Discipline discipline1 = new Discipline(1, "Banco de Dados", 30);
		Professor professor1 = new Professor(45675, "Abgair Simon Ferreira", LocalDate.of(1992, 04, 10), "Banco de Dados");

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(student1);
		session.save(discipline1);
		session.save(professor1);
		
		transaction.commit();
		session.close();

		UniClass uniClass1 = new UniClass("01/1998", 8.5, student1, discipline1, professor1);
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(uniClass1);
	
		transaction.commit();
		session.close();
	}

}