package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//create a course
			
			Course tempCourse = new Course ("Pacman gameming");
			
			//add some reviews
			
			tempCourse.addReview(new Review("great course ever1"));
			tempCourse.addReview(new Review("great course ever2"));
			tempCourse.addReview(new Review("great course ever3"));
			//save the course
			
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			
			session.close();
			factory.close();
		}
	}

}
