package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectJDBCconnectTest {

	public static void main(String[] args) throws SQLException {
		
		// initialize driver reference and register db
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//connect to db
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		
		//issue sql query select
		Statement stat = conn.createStatement();
		//execute query
		String query = "select * from students_info";
		ResultSet result = stat.executeQuery(query);
		//
		
	
	
	
	}

}
