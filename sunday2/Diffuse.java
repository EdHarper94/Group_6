import javax.swing.ImageIcon;

/**
 * Created by ifan on 04/12/2015.
 */
public class Diffuse {


    public void toggleDiffuseState(int x, int y)  {
        Board.getTile(x, y).setIsDiffused(!Board.getTile(x, y).getIsDiffused());
        Board.getTile(x, y).setIcon(new ImageIcon(Diffuse.class.getResource("/images/Actions-flag-blue-icon.png")));
        if((Board.getTile(x, y).getIsMine()) &&(Board.getTile(x, y).getIsDiffused())){
        	Counter.incrementDiffusedCount();
        }
        if((Board.getTile(x, y).getIsMine()) &&(!Board.getTile(x,y).getIsDiffused())){
        	Counter.decrementDiffusedCount();
        }
    }
}
