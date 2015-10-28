package RPS;

import java.sql.Connection;
import java.util.Scanner;

/** Main class
 * 
 * @author Bryan2
 *
 */
public class main {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	
    	Game game = new Game();
    	FormatTournament formatTournament = new FormatTournament();
    	DBConnection dbConnection = new DBConnection();
    	DBOperation dbOperation = new DBOperation();
    	
    	Scanner scanner = new Scanner(System.in);
    	
           
    	String tournament = "[ [ [ [\"Armando\", \"S\"], [\"Dave\", \"S\"] ], [ [\"Richard\", \"P\"], [\"Michael\", \"S\"] ], ], [ [ [\"Allen\", \"S\"], [\"Omer\", \"P\"] ], [ [\"John\", \"S\"], [\"Robert\", \"R\"] ] ] ]";
//    	String tournament = "[ [ [\"Armando\", \"P\"], [\"Dave\", \"S\"] ], [ [\"Richard\", \"R\"], [\"Michael\", \"S\"] ], ]";
      String single = "[[ \"Luis\", \"P\" ], [ \"Dave\", \"P\" ]]";
    	
    	Connection con;
    	
    	int action;
    	System.out.println("1. Single Match");
    	System.out.println("2. Tournament Match");
    	System.out.println("3. List Top 10");
    	System.out.println("4. Reset Database");
    	System.out.print("Enter an option: \n");
    	action = scanner.nextInt();
        
    	switch(action) {
    		
    	/** single game */
    		case 1: 
    			String singleArray[] = formatTournament.play(single);
    			String players[] = game.startSingleMatch(singleArray);    		
    			System.out.println("Single match!\n");
    			System.out.println("[" + players[0] + "] wins");    			
    			break;
    	
    	/** tournament game */	
    		case 2:
    			String tournamentArray[] = formatTournament.play(tournament);
    			String finalists[] = game.startTournament(tournamentArray);
    			System.out.println("Tournament!\n");
    		    System.out.println("Winner - [" + finalists[0] + "]");
    		    System.out.println("Second - [" + finalists[1] + "]");
    		    con = dbConnection.Connect();    	        
    	        dbOperation.tournamentWinner(con, finalists);
    	        dbConnection.Disconnet();
    	        break;
    	        
    	/** top ten list */
    		case 3:
    			con = dbConnection.Connect();
    			for(String player : dbOperation.topTen(con))
    	        	System.out.println(player);
    			dbConnection.Disconnet();
    			break;
    	
    	/** reset DB */
    		case 4:
    			con = dbConnection.Connect();
    			dbOperation.resetDB(con);
    			dbConnection.Disconnet();
    			System.out.println("Database cleaned");
    			break;
    		
    		default:
    			System.out.println("Invalid option!");
    			break;
    			
    	}

    }

}
