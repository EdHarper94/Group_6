/**
 * @file Counter.java
 * @author Xiao
 * @date 04/12/2015
 * @see Board.java
 * @see Diffuse.java
 * @see Mine.java
 * @see RevealAlgorithm.ava
 * @see Tile.java
 */
public class Counter {
	
	static int m_MineCount;
	static int m_DiffusedCount;
	static int m_RevealedTileCount;
	static int m_TilesRemainingCount;

	/**
	 * A normal member taking two arguments and returning
	 * @param numOfMines an integer argument.
	 * @param numOfTiles an integer argument.
	 * @return a constructor returns an instance of the object.
	 */
	
	public Counter(int numOfMines, int numOfTiles){
		m_DiffusedCount = 0;
		m_RevealedTileCount = 0;
		m_MineCount = numOfMines;
		m_TilesRemainingCount = numOfTiles*numOfTiles;
	}
	/**
	 * A normal member taking one argument and returning.
	 * @param numOfMines an integer argument.
	 * @return the number of mines.
	 */
	
	public static void setMineCount(int numOfMines){
		m_MineCount = numOfMines;
	}

	/**
	 * A normal member taking one argument and returning
	 * @param numOfTiles an integer argument.
	 * @return reducing the number of tiles remaining.
	 */

	public static void decrementTilesRemainingCount(){
		m_TilesRemainingCount --;
	}

	/**
	 * takes no arguments
	 * @return the number of diffused tiles gets lower
	 */

	public static void decrementDiffusedCount(){
		m_DiffusedCount --;
	}

	/**
	 * takes no arguments
	 * @return the counter of diffused tiles gets higher
	 */
	
	public static void incrementDiffusedCount(){
		m_DiffusedCount ++;
	}

	/**
	 * takes no arguments
	 * @return increments the number of revealed tile counter
	 */

	public static void incrementRevealedTileCount(){
		m_RevealedTileCount ++;
	}

	/**
	 * takes no arguments
	 * @return the number of mines in on the board
	 */

	public static int getMineCount(){
		return m_MineCount;
	}

	/**
	 * takes no arguments
	 * @return the number of tiles remaining
	 */

	public static int getTilesRemainingCount(){
		return m_TilesRemainingCount;
	}

	/**
	 * takes no arguments
	 * @return the number of revealed tiles
	 */

	public static int getRevealedTileCount(){
		return m_RevealedTileCount;
	}

	/**
	 * takes no arguments
	 * @return the number of diffused tiles
	 */

	public static int getDiffusedCount(){
		return m_DiffusedCount;
	}

	
	
}
