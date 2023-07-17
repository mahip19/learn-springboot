package com.mahip.cruddemo;

import com.mahip.cruddemo.dao.StudentDAO;
import com.mahip.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	commandlinerunner is from sping boot framwwork. this will run after spring beans is loaded
	@Bean
 	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudents(studentDAO);
			queryForStudents(studentDAO);
		};

	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		for (Student student : students){
			System.out.println(student);
		}
	}

	private void readStudents(StudentDAO studentDAO){
//		create student obj
		System.out.println("creating student");
		Student newStudent = new Student("mickey", "mouse", "mouse@gmail.com");
//		save student
		studentDAO.save(newStudent);

//		display id of saved
		System.out.println("saved student by id: " + newStudent.getId());
//		retrieve student by id
		System.out.println("retrieving student by id " + newStudent.getId());
		System.out.println("retrieved student: " + studentDAO.findById(newStudent.getId()));
//		display retrieved student
	}
	private void createMultipleStudents(StudentDAO studentDAO){
		//		crate student obj
		System.out.println("creating new student obj");
		Student newStudent1 = new Student("Peter", "Parker", "spiderman@gmail.com");
		Student newStudent2 = new Student("Jack", "Ryan", "ryan@gmail.com");
		Student newStudent3 = new Student("Bruce", "Banner", "batman@gmail.com");
		Student newStudent4 = new Student("Walter", "White", "heisenberg@gmail.com");

		//		save obj
		System.out.println("Saving students");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
		studentDAO.save(newStudent4);
//		display id of saved student obj
//		System.out.println("Id of new student: " + newStudent.getId());
	}
	private void createStudent(StudentDAO studentDAO) {
//		crate student obj
		System.out.println("creating new student obj");
		Student newStudent = new Student("Peter", "Parker", "spiderman@gmail.com");
//		save obj
		System.out.println("Saving studnet");
		studentDAO.save(newStudent);
//		display id of saved student obj
		System.out.println("Id of new student: " + newStudent.getId());
	}
}
