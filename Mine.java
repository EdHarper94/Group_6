
public class Mine extends Tile{
	
	private boolean m_IsMine;
	
	public Mine(int xPos, int yPos, boolean isHidd, boolean isDiff, boolean mine){
		super(xPos, yPos, isHidd, isDiff);
		m_IsMine = mine;
	}
	
	public void setIsMine(boolean mine){
		m_IsMine = mine;
	}
	
	public boolean getIsMine(){
		return m_IsMine;
	}
}
