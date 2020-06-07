package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.entity.Instructor;
import com.lu2code.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			// create the objects
			Instructor instructor = new Instructor("somnath", "roy", "xvz.@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://wwwluv2code.com", "Luv 2 code");
			// associate the objects.association done in memery
			instructor.setInstructorDetail(instructorDetail);
			// save the instructor.This will save the instructorDetail too
			// due to CascadeType.All
			session.save(instructor);
			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
