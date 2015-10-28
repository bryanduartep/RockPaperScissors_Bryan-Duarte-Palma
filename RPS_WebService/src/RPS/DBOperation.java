package RPS;

/**Class that makes operations on DB
 * 
 * @author Bryan2
 * 
 */

import java.sql.*;

public class DBOperation {
	
	
	//save winner and second place of a tournament
	@SuppressWarnings("unused")
	public void tournamentWinner(Connection connection, String finalist[]) {
		
		String winner = finalist[0].split(",")[0].replaceAll("\"", "");
		String second = finalist[1].split(",")[0].replaceAll("\"", "");
		
		String sqlString = "insert into rockpaperscissor.player (Name,Points) values ('" + winner + "', 3) on duplicate key update "
				+ "Name = Name, Points = Points + 3;";
		
		String sqlString2 = "insert into rockpaperscissor.player (Name,Points) values ('" + second + "', 0) on duplicate key update "
				+ "Name = Name, Points = Points;";
		
		try{
			
			int sentence = connection.createStatement().executeUpdate(sqlString);
			int sentence2 = connection.createStatement().executeUpdate(sqlString2);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	// reset DB
	@SuppressWarnings("unused")
	public void resetDB(Connection connection) {
		
		String sqlString = "Truncate table rockpaperscissor.player";
		String sqlString2 = "Truncate table rockpaperscissor.tournament";
		
		try{
			
			int sentence = connection.createStatement().executeUpdate(sqlString);
			int sentence2 = connection.createStatement().executeUpdate(sqlString2);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	// select top 10 players
	public String[] topTen(Connection connection) {
		
		String result = "";
		String sqlString = "SELECT * FROM rockpaperscissor.player order by Points desc limit 10;";
		
		try{
			
			ResultSet sentence = connection.createStatement().executeQuery(sqlString);
			
			while(sentence.next()) {

				result = result + ";#@" + sentence.getString("Name") + " - " + sentence.getString("Points");				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String topTen[] = result.split(";#@");
		return topTen;
	}
}
