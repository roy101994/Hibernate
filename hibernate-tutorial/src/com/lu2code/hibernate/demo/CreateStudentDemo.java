package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Use the sessionObject to save the Java Object
			// Create a Student Object
			System.out.println("Creating a new Student Object......");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			Student s2 = new Student("Allan", "Test", "test@luv2code.com");
			// start the transaction
			session.beginTransaction();
			// save the Student Object
			session.save(tempStudent);
			session.save(s2);
			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
