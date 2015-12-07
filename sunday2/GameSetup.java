/**
 * @file GameSetup.java
 * @author James Michael
 * @date 02 Dec 2015
 * This class sets the values for name, gametype, and number of
 * tiles and mines, and can be accessed by other classes through
 * get methods.
 */
public class GameSetup {
	private static String m_PlayerName;
	private static int m_NumberOfTiles;
	private static int m_NumberOfMines;
	private boolean m_CustomGame;
	
	public GameSetup(String name, int enteredNumOfTiles, int enteredNumOfMines, boolean gameType){
		setName(name);
		setNumberOfTiles(enteredNumOfTiles);
		setNumberOfMines(enteredNumOfMines);
		setGameType(gameType);
	}

	/**
	 * Gets the entered name of the player
	 * @return the player's name
	 */
	public static String getName(){
		return m_PlayerName;
	}

	/**
	 * Gets the gametype specified by the player
	 * @return a boolean representing custom game
	 */
	public boolean getGameType(){
		return m_CustomGame;
	}

	/**
	 * Gets the number of tiles entered by the player
	 * @return the number of tiles chosen
	 */
	public static int getNumberOfTiles(){
		return m_NumberOfTiles;
	}

	/**
	 * Gets the number of mines entered by the player
	 * @return the number of mines chosen
	 */
	public static int getNumberOfMines(){
		return m_NumberOfMines;
	}

	/**
     * Taking one argument and setting whether a custom game was chosen.
     * @param gameType a boolean argument
     */
	public void setGameType(boolean gameType){
		if (gameType == false){
			m_CustomGame = false;
		}
		else{
			m_CustomGame = true;
		}
	}

	/**
     * Taking one argument and setting the name of the player.
     * @param name a String argument
     */
	public static void setName(String name){
		m_PlayerName = name;
	}

	/**
     * Taking one argument and setting the number of tiles specified.
     * @param enteredNumOfTiles an integer argument
     */
	public static void setNumberOfTiles(int enteredNumOfTiles){
		m_NumberOfTiles = enteredNumOfTiles;
	}

	/**
     * Taking one argument and setting the number of mines specified.
     * @param enteredNumOfMines an integer argument
     */
	public void setNumberOfMines(int enteredNumOfMines){
		m_NumberOfMines = enteredNumOfMines;
	}
	
}