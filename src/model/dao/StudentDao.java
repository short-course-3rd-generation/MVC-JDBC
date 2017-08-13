package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datasource.Database;
import model.dto.Student;

public class StudentDao {
	private List<Student> students=new ArrayList<>();
	
	public StudentDao() {
		/*for(int i =0; i<5; i++) {
			students.add(new Student(
					"00"+i,
					"test"+i
					));
		}*/
	}
	
	public List<Student> getStudents(){
		
		Connection conn=null;
		Statement stm=null;
		ResultSet rs=null;
		conn=Database.getConnection();
		
		try {
			
			stm=conn.createStatement();
			rs=stm.executeQuery("SELECT * FROM student");
			while(rs.next()) {
				students.add(new Student(
						rs.getString("role_on"),
						rs.getString("name")
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return students;		
	}

	public void createStdent(Student stu) {
		Connection conn=null;
		PreparedStatement stm=null;
		conn=Database.getConnection();
		
		try {
			
			stm=conn.prepareStatement("INSERT INTO student values(?,?)");
			stm.setString(1, stu.getRoleNo());
			stm.setString(2, stu.getName());
			stm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
