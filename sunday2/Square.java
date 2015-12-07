import java.awt.*;
import javax.swing.ImageIcon;

/**
 * @file Square.java
 * @author eghar
 * @date 1st November
 * @see Tile.java , Mine.java
 */

public class Square extends Tile  {

    private int m_NumOfMinesAdjacent;

    public Square(int xPos, int yPos, boolean isHidd, boolean isDiff, int mineAdj){
        super(xPos, yPos, isHidd, isDiff);
        setNumOfMinesAdjacent(mineAdj);
        super.setM_IsMine(false);
        addMouseListener(new Player());
    }
    
    /**
     * Set Number of mines adjacent (8x8) to square.
     * @param numMines int number of mines adjacent.
     */

    public void setNumOfMinesAdjacent(int numMines)   {
        m_NumOfMinesAdjacent = numMines;
    }

    /**
     * Increments Number of adjacent mines.
     */
    public void increaseMineCount() {
        m_NumOfMinesAdjacent++;
    }
    
    /**
     * Gets number of Mines Adjacent to square.
     * @return m_NumOfMinesAdjacents
     */
    public int getNumOfMinesAdjacent(){
        return m_NumOfMinesAdjacent;
    }
    
    
    /**
     * Toggles image on square.
     * Sets numbers for number of adjacent mines.
     */
    public void paintComponent(Graphics graphics)    {
        super.paintComponent(graphics);
        if (getIsHidden())  {
        }
        if (getIsDiffused() && getIsHidden()){
        	setIcon(new ImageIcon(Square.class.getResource("/images/Actions-flag-blue-icon.png")));
        }
        if (!getIsDiffused() && getIsHidden()){
        	setIcon(null);
        }
        if (!getIsHidden()) {
            if (getNumOfMinesAdjacent() != 0) {
            	setFont(new Font("Arial", Font.BOLD, 10));
            	setText(Integer.toString(getNumOfMinesAdjacent()));
            }
        }
 
    }
}
