/**
 * @file GameResult.java
 * @author James Michael
 * @date 03 Dec 2015
 *
 * This class is used to help calculate when the game has been won or lost.
 * RevealAlgorithm sets the game result to a loss immediately upon clicking a mine,
 * whereas this class collaborates with Counter to work out when the game has been won.
 */
public class GameResult{
	private boolean m_GameWon;
	private static boolean m_GameLost;
	private int m_TotalTiles;

	public GameResult(){ 
		m_GameWon = false;
		m_GameLost = false;
		m_TotalTiles = GameSetup.getNumberOfTiles() * GameSetup.getNumberOfTiles();
	}

	/**
	 * Gets the game result if the game has been won
	 * @return a boolean value representing game won
	 */
	public boolean getGameResult(){
		return m_GameWon;
	}

	/**
	 * Gets the game result if the game has been lose
	 * @return a boolean value representing game lost
	 */
	public boolean getGameLoss(){
		return m_GameLost;
	}

	/**
     * Calculates the winning condition of the game -
	 * if the number of mines diffused is equal to the total mines and 
	 * the total tiles minus the revealed tiles is equal to the mine count then 
	 * the game has been won. Otherwise it has not yet been won.
	 * @param
	 * @see Counter.java for the get methods used
	 */
	public void setGameResult(){
		if (Counter.getDiffusedCount() == Counter.getMineCount()){
			if ((m_TotalTiles - Counter.getRevealedTileCount()) == Counter.getMineCount()){
				m_GameWon = true;
			}
		} else {
			m_GameWon = false;
		}		
	}
	
	/**
     * Taking in one argument and setting the game result to a loss
	 * @param loss a boolean argument
	 * @see RevealAlgorithm.java for where this method is used
	 */
	public static void setGameLoss(boolean loss){
		m_GameLost = loss;		
	}
}