import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

/**
 * Created by ifan on 03/12/2015.
 */
public class Square extends Tile  {

    private int m_NumOfMinesAdjacent;

    public Square(int xPos, int yPos, boolean isHidd, boolean isDiff, int mineAdj){
        super(xPos, yPos, isHidd, isDiff);
        setM_NumOfMinesAdjacent(mineAdj);
        super.setM_IsMine(false);
        addMouseListener(new Player());
    }
    public int getNumOfMinesAdjacent(){
        return m_NumOfMinesAdjacent;
    }

    public void setM_NumOfMinesAdjacent(int numMines)   {
        m_NumOfMinesAdjacent = numMines;
    }

    public void increaseMineCount() {
        m_NumOfMinesAdjacent++;
    }
    public void paintComponent(Graphics graphics)    {
        super.paintComponent(graphics);
        if (getIsHidden())  {
            //graphics.setColor(getColor());
        }
        if (getIsDiffused() && getIsHidden())    {
            //Color diffusedTile = Color.yellow;
        	setIcon(new ImageIcon(Square.class.getResource("/images/Actions-flag-blue-icon.png")));
        	//graphics.setColor(diffusedTile);
            //graphics.fillRect(20,20,20,20);
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
