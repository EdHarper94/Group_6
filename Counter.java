
public class Counter {
	
	static int m_MineCount;
	static int m_DiffusedCount;
	static int m_RevealedTileCount;
	static int m_TilesRemainingCount;
	
	public Counter(int numOfMines, int numOfTiles){
		m_DiffusedCount = 0;
		m_RevealedTileCount = 0;
		m_MineCount = numOfMines;
		m_TilesRemainingCount = numOfTiles;
	}
	
	public void setMineCount(int numOfMines){
		m_MineCount = numOfMines;
	}
	
	public void setTileRemainingCount(int numOfTiles){
		m_TilesRemainingCount = numOfTiles;
	}
	
	public void decrementTilesRemainingCount(){
		m_TilesRemainingCount --;
	}
	
	public void incrementDiffusedCount(){
		m_DiffusedCount ++;
	}
	
	public void incrementRevealedTileCount(){
		m_RevealedTileCount ++;
	}
	
	public int getMineCount(){
		return m_MineCount;
	}

	public int getTilesRemainingCount(){
		return m_TilesRemainingCount;
	}
	
	public int getReveleadTileCount(){
		return m_RevealedTileCount;
	}
	
	public int getDiffusedCount(){
		return m_DiffusedCount;
	}

	
	
}
