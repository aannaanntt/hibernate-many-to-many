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

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			System.out.println("Creating the course");
			Course tempCourse = new Course("Learn Java in 20 days");

			System.out.println("Saving the course" + tempCourse);
			session.save(tempCourse);

			System.out.println("Creating student");
			Student std = new Student("Anant", "Mishra", "anantmishra2307@gmail.com");
			Student std1 = new Student("Ria", "Arora", "rriiaa@gmail.com");

			// add student to the course;
			tempCourse.addStudent(std);
			tempCourse.addStudent(std1);
			// create the student
			// save the student
			System.out.println("Saving the student");

			session.save(std);
			session.save(std1);

			System.out.println("Saved Students" +" "+ tempCourse.getStudents());

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
			session.close();
		}

	}

}
