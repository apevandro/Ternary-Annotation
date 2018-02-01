package ternary.app;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ternary.Discipline;
import ternary.Professor;
import ternary.Student;

import hibernate.utils.HibernateUtil;

public class App {

	public static void main(String[] args) {
		App app = new App();

		app.insertion();    // insertion can also be done using insertion.txt file commands
                            // do not forget to update mapping class in hibernate.cfg.xml file

		//app.loadProfessor();
		//app.deleteProfessor();
	}

	public void insertion() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

	    Student student1 = new Student(111, "Edvaldo Carlos Silva", "Av. Sao Carlos, 186", "Sao Carlos-SP");
	    Student student2 = new Student(112, "Joao Benedito Scapin", "R. Jose Bonifacio, 70", "Sao Carlos-SP");
	    Student student3 = new Student(113, "Carol Antonia Silveira", "R. Luiz Camoes, 120", "Ibate-SP");
		
		Discipline discipline1 = new Discipline(1, "Banco de Dados", 30);
		Discipline discipline2 = new Discipline(2, "Estrutura de Dados", 30);
		   
		Professor professor1 = new Professor(45675, "Abgair Simon Ferreira", LocalDate.of(1992, 04, 10), "Banco de Dados");
		
		professor1.getClassMap().put(student1, discipline1);
		professor1.getClassMap().put(student2, discipline1);
		professor1.getClassMap().put(student2, discipline2);
		professor1.getClassMap().put(student3, discipline2);

		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(discipline1);
		session.save(discipline2);
		session.save(professor1);
		
        transaction.commit();
		session.close();
	}
	
	public void loadProfessor() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "select p from Professor p where p.name like 'Abgair Simon Ferreira'";
		Professor professor = session.createQuery(hql, Professor.class).getSingleResult();

		professor.getClassMap().keySet().stream()
		                                .forEach(student -> System.out.println("Student name: " + student.getName()));

		professor.getClassMap().values().stream()
		                                .map(discipline -> discipline.getName())
		                                .distinct()
		                                .forEach(name -> System.out.println("Discipline name: " + name));

		transaction.commit();
		session.close();
	}

	public void deleteProfessor() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "select p from Professor p where p.name like 'Abgair Simon Ferreira'";
		Professor professor = (Professor) session.createQuery(hql).getSingleResult();

		professor.getClassMap().clear();

		session.delete(professor);
		transaction.commit();
		session.close();
	}

}