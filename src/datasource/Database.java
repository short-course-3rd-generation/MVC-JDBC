package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static String  URL="jdbc:postgresql://127.0.0.1:5000/EXPERT";
	
	
	public Database() {}
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(URL,"postgres","123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
