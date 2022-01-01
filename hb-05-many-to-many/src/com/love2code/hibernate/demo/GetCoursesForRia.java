package com.love2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;
import com.love2code.hibernate.demo.entity.Student;

public class GetCoursesForRia {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
				//get student ria from the database 
				 String id = "2";
				 Student std = session.get(Student.class, id);
				 
				 System.out.println(std.getCourses());
				 
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
			session.close();
		}

	}

}
