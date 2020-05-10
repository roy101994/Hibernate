package com.lu2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query the students
			List<Student> theStudents = session.createQuery("from Student").list();

			//displayStudents(theStudents);

			// query students table to find all students whose name end with Doe

			theStudents = session.createQuery("from Student s where s.lastName='Wall'").list();

			displayStudents(theStudents);

			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		// display the students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent.getEmail());
		}
	}

}
