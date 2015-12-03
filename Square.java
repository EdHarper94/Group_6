
public class Square extends Tile {
	
	private int m_NumOfMinesAdjacent;
	
	public Square(int xPos, int yPos, boolean isHidd, boolean isDiff, int numMines){
		super(xPos, yPos, isHidd, isDiff);
		m_NumOfMinesAdjacent = numMines;
	}

	public void setNumOfMinesAdjacent(int numMines){
		m_NumOfMinesAdjacent = numMines;
	}

	public int getNumOfMinesAdjacent(){
		return m_NumOfMinesAdjacent;
	}
	
}
