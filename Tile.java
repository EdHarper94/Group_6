import javax.swing.*;
import java.awt.*;

/**
 * @file Tile.java
 * @author Edward Harper
 * @date 1st November
 * @see Square.java , Mine.java
 */
public class Tile extends JButton{

    private int m_XPosition;
    private int m_YPosition;
    private boolean m_IsHidden;
    private boolean m_IsDiffused;
    private boolean m_IsMine;

    public Tile(int xPos, int yPos, boolean isHidd, boolean isDiff){
        m_XPosition = xPos;
        m_YPosition = yPos;
        m_IsHidden = isHidd;
        m_IsDiffused = isDiff;
        setPreferredSize(new Dimension(100, 100));
    }

    /**
     * Taking one argument and setting Tile x position
     * @param xPos an integer x coordinate position
     */
    public void setXPosition(int xPos){
        m_XPosition = xPos;
    }

    /**
     * Taking one argument and setting tile y position
     * @param yPos an integer y coordinate position
     */
    public void setYPosition(int yPos){
        m_YPosition = yPos;
    }

    /**
     * Taking one argument and setting tile hidden boolean value
     * @param isHidd an boolean variable. True for when Tile is hidden.
     */
    public void setIsHidden(boolean isHidd){
        m_IsHidden = isHidd;
    }

    /**
     * Taking one argument and setting tile diffused value
     * @param isDiff a boolean variable. True for when tile is diffused.
     */
    public void setIsDiffused(boolean isDiff){
        m_IsDiffused = isDiff;
    }

    /**
     * Taking one argument and setting whether tile is a mine.
     * @param isMine a boolean variabe. True for when tile is mine.
     */
    public void setM_IsMine(Boolean isMine)   {
        m_IsMine = isMine;
    }

    /**
     * Getting tile x position.
     * @return returns x position of tile.
     */
    public int getXPosition(){
        return m_XPosition;
    }
    
    
    /**
     * Getting tile y position
     * @return y position of tile
     */
    public int getYPosition(){
        return m_YPosition;
    }

    /**
     * Getting hidden value of tile.
     * @return the tile boolean hidden value.
     */
    public boolean getIsHidden(){
        return m_IsHidden;
    }

    /**
     * Getting diffused value of tile.
     * @return the tile boolean diffused value.
     */
    public boolean getIsDiffused(){
        return m_IsDiffused;
    }
    
    /**
     * Getting mine value of tile.
     * @return the tile boolean mine value.
     */
    public boolean getIsMine(){
        return m_IsMine;
    }

    
}
