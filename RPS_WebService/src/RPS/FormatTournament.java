package RPS;

public class FormatTournament {
	
	public String[] play(String tournament) {

		String tournamentArray[] = tournament.replaceAll(" ", "").split("],\\[");
		
		for(int i = 0; i < tournamentArray.length; i++) {
			
			tournamentArray[i] = tournamentArray[i].replaceAll("\\[", "");
			tournamentArray[i] = tournamentArray[i].replaceAll("]", "");				
		}
		
//		System.out.println("--------------------------\nPlayers are: ");
//		 for (String x : tournamentArray) {
//     	   System.out.println(x);
//     	}
//		 System.out.println("--------------------------\n");
		 
		return tournamentArray;	
	}

}
