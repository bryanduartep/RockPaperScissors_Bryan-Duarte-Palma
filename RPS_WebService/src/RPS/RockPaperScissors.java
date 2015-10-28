package RPS;

/** Class the define the game rules
 * 
 * @author Bryan2
 *
 */

public class RockPaperScissors {
 
    private enum Move {
        ROCK, PAPER, SCISSORS, ERROR;
 
        /**
         * Compares this move with another move to determining a tie, a win, or
         * a loss.
         * 
         * @param otherMove
         *            move to compare to
         * @return 0 if these moves tie, 1 if this move beats the other move, 2 if this move loses to
         *         the other move, -1 if a move is invalid
         */
        public int compareMoves(Move otherMove) {
            
        	// if someone uses an invalid strategy
        	if(this == ERROR || otherMove == ERROR)
            	return -1;
        	
        	// Tie
            if (this == otherMove)
                return 0;
 
            switch (this) {
            case ROCK:
                return (otherMove == SCISSORS ? 1 : 2);
            case PAPER:
                return (otherMove == ROCK ? 1 : 2);
            case SCISSORS:
                return (otherMove == PAPER ? 1 : 2);
            }
            return -1;
        }
    }
 
 
        public Move getMove(String strategy) {       	 
        	
            strategy = strategy.toUpperCase();
            char firstLetter = strategy.charAt(0);
            if (firstLetter == 'R' || firstLetter == 'P' || firstLetter == 'S') {
                switch (firstLetter) {
                case 'R':
                    return Move.ROCK;
                case 'P':
                    return Move.PAPER;
                case 'S':
                    return Move.SCISSORS;
                }
            }

            return Move.ERROR;
        }
 
 
    public RockPaperScissors() {
        
    }
    
    private String[] getFormatPlayerStrategy(String playerStrategy) {
    	
    	String playerStrategyArray[] = playerStrategy.split(",");
    	playerStrategyArray[0] = playerStrategyArray[0].replaceAll("\"", "");
    	playerStrategyArray[1] = playerStrategyArray[1].toUpperCase().replaceAll("\"", "");
    	
    	return playerStrategyArray;
    	
    }
    
 
    public String[] getWinner(String player1, String player2) {
 
    	String playerStrategy1[] = getFormatPlayerStrategy(player1);
    	String playerStrategy2[] = getFormatPlayerStrategy(player2);
    	
    	String finalist[] = new String[2];
    	
        // Get moves
        Move player1Move = getMove(playerStrategy1[1]);
        Move player2Move = getMove(playerStrategy2[1]);
 
        // Compare moves and determine winner
        int compareMoves = player1Move.compareMoves(player2Move);
        switch (compareMoves) {
        
        case 0: // Tie - player1 wins        	
        	finalist[0] = "\"" + playerStrategy1[0] + "\",\"" + playerStrategy1[1] + "\"";
        	finalist[1] = "\"" + playerStrategy2[0] + "\",\"" + playerStrategy2[1] + "\"";
        	break;
        	
		case 1: // Player1 wins
        	finalist[0] = "\"" + playerStrategy1[0] + "\",\"" + playerStrategy1[1] + "\"";
        	finalist[1] = "\"" + playerStrategy2[0] + "\",\"" + playerStrategy2[1] + "\"";
        	break;
        	
		case 2: // Player2 wins
			finalist[0] = "\"" + playerStrategy2[0] + "\",\"" + playerStrategy2[1] + "\"";
			finalist[1] = "\"" + playerStrategy1[0] + "\",\"" + playerStrategy1[1] + "\"";
			break;
			
		case -1:
        	finalist[0] = "Error";
        	finalist[1] = "Error";
        	break;
        }
		return finalist;
    }
}
