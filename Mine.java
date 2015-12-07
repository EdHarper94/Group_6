import java.awt.*;
import javax.swing.ImageIcon;

/**
 * @file Mine.java
 * @author Edward Harper
 * @date 1st November.
 * @see Tile.java , Square.java
 */

public class Mine extends Tile{

    private static Boolean allMinesHidden = true;

    public Mine(int xPos, int yPos, boolean isHidd, boolean isDiff){
        super(xPos, yPos, isHidd, isDiff);
        createMine();
        addMouseListener(new Player());
    }

    /**
     * Setting iSMine boolean value; 
     */
    public void createMine()   {
        super.setM_IsMine(true);
    }

    /**
     * Revealse all mines on game loss.
     */
    public static void revealAllMines() {
        allMinesHidden = false;
    }

    /**
     * Toggles Diffused Image on Mine
     * Sets Bomb image on reveal.
     */
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if (getIsHidden())  {
        }
        if (getIsDiffused() && getIsHidden()){
        	setIcon(new ImageIcon(Mine.class.getResource("/images/Actions-flag-blue-icon.png")));
        }
        if (!getIsDiffused() && getIsHidden()){
        	setIcon(null);
        }
        if (!getIsHidden() ) {
            setIcon(new ImageIcon(Mine.class.getResource("/images/Bomb-icon.png")));
            setDisabledIcon(new ImageIcon(Mine.class.getResource("/images/Bomb-icon.png")));
        }
    }
}
