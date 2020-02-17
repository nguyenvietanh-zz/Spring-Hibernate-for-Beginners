package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery("from Student  s where s.lastName = 'Nguyen'").list();
			System.out.println("Students who have last name of A");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Nguyen' OR s.firstName = 'VA2'").list();
			System.out.println("\n\nStudents who have last name and lastname: ");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			System.out.println("n\nStudents who have email of A");
			displayStudents(theStudents);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
