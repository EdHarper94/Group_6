import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @file Player.java
 * @author Yousef
 * @date 04/12/2015
 * @see RevealAlgorithm.java for related stuff
 * @see Boardclass.java for related stuff
 * @see Tile.java for related stuff
 */
public class Player implements MouseListener{

    private RevealAlgorithm revealAlgorithm;
    private Diffuse diffuse;

    /**
     * A normal member taking one argument and returning
     * @param e a MouseEvent argument.
     * @see getSource()
     * @see getButton()
     * @see getXPosition()
     * @see getYPosition()
     * @see ifMine()
     * @return When clicking on a tile you can either defuse or reveal it.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Tile t = (Tile) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON3)    {
            diffuse = new Diffuse();
            diffuse.toggleDiffuseState(t.getXPosition(),t.getYPosition());
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            revealAlgorithm = new RevealAlgorithm();
            revealAlgorithm.floodFill(t.getXPosition(), t.getYPosition());
            if (t.getIsMine())  {
                revealAlgorithm.ifMine(t.getXPosition(), t.getYPosition());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
