import java.awt.*;
import java.awt.print.Book;

import javax.swing.ImageIcon;

/**
 * Created by ifan on 03/12/2015.
 */
public class Mine extends Tile{

    private Color mineColor = Color.red;
    private static Boolean allMinesHidden = true;

    public Mine(int xPos, int yPos, boolean isHidd, boolean isDiff){
        super(xPos, yPos, isHidd, isDiff);
        createMine();
        addMouseListener(new Player());
    }

    public void createMine()   {
        super.setM_IsMine(true);
    }

    public static void revealAllMines() {
        allMinesHidden = false;
    }

    public void paintComponent(Graphics graphics)    {
        super.paintComponent(graphics);
        if (getIsHidden())  {
            //graphics.setColor(getColor());
        }
        if (getIsDiffused() && getIsHidden())    {
            //Color diffusedTile = Color.yellow;
        	setIcon(new ImageIcon(Mine.class.getResource("/images/Actions-flag-blue-icon.png")));
        	
        	//graphics.setColor(diffusedTile);
            //graphics.fillRect(20,20,20,20);
        }
        if (!getIsDiffused() && getIsHidden()){
        	setIcon(null);
        }
        if (!getIsHidden() ) {
            mineColor = Color.red;
            setIcon(new ImageIcon(Mine.class.getResource("/images/Bomb-icon.png")));
            setDisabledIcon(new ImageIcon(Mine.class.getResource("/images/Bomb-icon.png")));
            //graphics.setColor(mineColor);
            //graphics.fillRect(0,0,100,100);
        }
        //graphics.fillRect(0, 0 , 100, 100);
    }
}
