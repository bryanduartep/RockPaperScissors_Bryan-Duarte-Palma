package RPS;

/** Class that handle the connection on DB
 * 
 * @author Bryan2
 * 
 */

import java.sql.*;

public class DBConnection {
	
	Connection connection;
	
	public DBConnection() {
	connection = null;
	}
	
	// open connection
	public Connection Connect() {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {

		    System.out.println(e.toString());

		}
		
		try {
			
			connection = (Connection) DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/rockpaperscissor?"
		            + "user=root&password=bduarte");
			
		} catch (SQLException ex) {

		    System.out.println("SQLException: " + ex.getMessage());
		}
		
		return connection;
		
	}
	
	// close db connection
	public void Disconnet() {
		
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
