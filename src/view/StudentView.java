package view;

import java.util.List;

import controller.StudentController;
import model.dto.Student;

public class StudentView {

	public void printStudents(List<Student> list) {
		if(list!=null) {
			list.forEach(a->{
				System.out.println("==========");
				System.out.println(a.toString());
			});
		}
	}
	
	public static void main(String[] args) {
		StudentController controller=new StudentController();
		controller.getStudentDetail();
	}
}
