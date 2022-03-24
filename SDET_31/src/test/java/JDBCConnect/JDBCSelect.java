package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import java.sql.SQLException;

public class JDBCSelect
{
	public static void main(String[] args) throws SQLException{
		Connection conn= null;
		 //putting the whole code in try catch to close the db connection
		try {
		//step1 : Load/ register mySQL Database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2: connect to DB
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		System.out.println("connection is succesfull");
		
		//step3: issue SQL Query
		Statement stat= conn.createStatement();
		
		//step 4: execute the query
		String query = "select * from student_info";
		ResultSet result = stat.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			//step 5: close DB Connection
			conn.close();
			System.out.println("closed the DB connection successfully");
		
		}
		
	}
		
}
