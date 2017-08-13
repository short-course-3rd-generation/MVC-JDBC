package controller;

import java.util.List;

import model.dao.StudentDao;
import model.dto.Student;
import view.StudentView;

public class StudentController {

	private StudentView view;
	private StudentDao dao;
	
	public StudentController() {
		view=new StudentView();
		dao=new StudentDao();
	}
	
	public List<Student> getStudentDetail() {	
		return dao.getStudents();
		//view.printStudents(list);
		
	}

	public void createStudent(Student stu) {
		dao.createStdent(stu);
	}
}
