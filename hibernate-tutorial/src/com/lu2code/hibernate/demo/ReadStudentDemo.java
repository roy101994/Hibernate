package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Testt", "WallStreett", "wall@luv2code.com");
			// start the transaction
			session.beginTransaction();
			// save the Student Object
			session.save(tempStudent);
			// commit the transaction
			session.getTransaction().commit();
			// Reading the objects
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Student Id:" + tempStudent.getId());
			Student s = session.get(Student.class, tempStudent.getId());
			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
