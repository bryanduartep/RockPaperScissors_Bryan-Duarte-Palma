package RPS;

/**
 * Class to make the single or tournament games
 * 
 * @author Bryan2
 *
 */

public class Game {
	String finalists[];
	String winner;
	String loser;
	
	public Game() {
		finalists = new String[2];
		winner = new String();
		loser = new String();
	}
	
	// for single match
	public String[] startSingleMatch(String players[]) {
		
		RockPaperScissors rps = new RockPaperScissors();
		
		if(players.length == 2) {
			
			finalists = rps.getWinner(players[0], players[1]);
			if(winner.equals("Error")) {
				System.out.println("Error, invalid strategy ---> [ [" + players[0] + ", " + players[1] + "] ]");				
			}
			
		}
		
		else
			System.out.println("Error, incorrect number of players");
		
		return finalists;
	}
	
	// for a tournament match
	public String[]  startTournament(String players[]) {
		
		RockPaperScissors rps = new RockPaperScissors();
		
		if(IsPowerOf(players.length, 2) && players.length >= 2) {
			
			String newPlayers[] = new String[players.length / 2];
			
			boolean errorStrategy = false;
			
			int i = 0;
			int k = 0;
			
			while(players.length > 1) {
				
				
				while(i < players.length) {
				
					finalists = rps.getWinner(players[i], players[i + 1]);
					newPlayers[k] = winner = finalists[0];
					loser = finalists[1];
					
					if(winner.equals("Error")) {
						System.out.println("Error, invalid strategy ---> [ [" + players[i] + ", " + players[i + 1] + "] ]");
						errorStrategy = true;
						break;
					}
					i = i + 2;
					k++;
				}
				
				if(errorStrategy)
					break;
				
				if(newPlayers.length > 1) {
					
					i = 0;
					k = 0;
					
					players = new String[newPlayers.length];
					players = newPlayers;
					newPlayers = new String[players.length / 2];
												
				} else {
					break;
				}
			}
			
			winner = newPlayers[0];
			
		}
			
		else
			System.out.println("Error, incorrect number of players");
		
		
		return finalists;
	}
	
	// to know if the number of players are 2 ^ k
	 public  boolean IsPowerOf(int n,int b)
	    {
	        if (n > 1)
	        {
	            while (n % b == 0)
	            {
	                n /= b;
	            }
	        }
	        return n == 1;
	    }

}
