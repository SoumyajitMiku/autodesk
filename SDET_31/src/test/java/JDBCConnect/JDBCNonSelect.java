 package JDBCConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCNonSelect {

	public static void main(String[] args) throws SQLException
	{
		Connection  conn=null;
		int result = 0;
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		//issue SQL Query -- can be select or insert or delete
		Statement stat = conn.createStatement();
		
		String query = "insert into student_info values('7','Ravi','Srivastava', 'KA')";
		 result = stat.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
		if(result==1)
		{
			System.out.println("inserted Successfully == PASS");
			
		}
		else
		{
			System.out.println("failed to insert == FAIL");
			
		}
		
		conn.close();
	}
	
	}

}
