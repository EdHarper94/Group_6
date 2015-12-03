
public class Tile {
	
	private int m_XPosition;
	private int m_YPosition;
	private boolean m_IsHidden;
	private boolean m_IsDiffused;
	
	public Tile(int xPos, int yPos, boolean isHidd, boolean isDiff){
		m_XPosition = xPos;
		m_YPosition = yPos;
		m_IsHidden = isHidd;
		m_IsDiffused = isDiff;
	}
	
	public void setXPosition(int xPos){
		m_XPosition = xPos;
	}
	
	public void setYPosition(int yPos){
		m_YPosition = yPos;
	}
	
	public void setIsHidden(boolean isHidd){
		m_IsHidden = isHidd;
	}
	
	public void setIsDiffused(boolean isDiff){
		m_IsDiffused = isDiff;
	}
	
	public int getXPosition(){
		return m_XPosition;
	}
	
	public int getYPosition(){
		return m_YPosition;
	}
	
	public boolean getIsHidden(){
		return m_IsHidden;
	}
	
	public boolean getIsDiffused(){
		return m_IsDiffused;
	}
	
}
