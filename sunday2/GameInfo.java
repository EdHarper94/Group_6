import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * @file GameInfo.java
 * @author James Michael
 * @date 05 Dec 2015
 * @see Game.java for where the labels and fields are printed
 *
 * This class creates some JLabels and JTextFields which are later added to
 * the main frame in Game. We tried to add all JLabels and JTextFields to
 * this class where they could be created, however a few would not work 
 * since they need to be constantly updated (i.e. the time elapsed)
 */
public class GameInfo {
    private JLabel m_NameLabel;
    private JLabel m_TimeLabel;
    private JLabel m_MinesDiffusedLabel;
    private JLabel m_MinesPresentLabel;
    private JLabel m_HiddenTilesLabel;
    private JLabel m_RevealedTilesLabel;
    private JTextField m_DisplayNameLabel;
    private JTextField m_DisplayMinesPresLabel;
    private final int LABEL_X = 420;
    private final int NAME_Y = 40;
    private final int LABEL_WIDTH = 120;
    private final int LABEL_HEIGHT = 30;
    private final int DISP_LABEL_X = 530;
    private final int TIME_Y = 100;
    private final int MINES_DIFF_Y = 160;
    private final int MINES_PRES_Y = 220;
    private final int HIDD_TILES_Y = 280;
    private final int REV_TILES_Y = 340;

    /**
     * Gets a created JLabel used to display 'Name:' to the frame
     * @return a JLabel used with name 
     */
	public JLabel getNameLabel(){
        m_NameLabel = new JLabel();
        m_NameLabel.setText("Name: ");
        m_NameLabel.setBounds(LABEL_X,NAME_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_NameLabel.setVisible(true);
        return m_NameLabel;
  	}
	
    /**
     * Gets a created JTextField used to display the player's name
     * @return a JTextField used for player's entered name
     */
	public JTextField getDisplayNameLabel(){
        m_DisplayNameLabel = new JTextField(20);
        m_DisplayNameLabel.setText(GameSetup.getName());
        m_DisplayNameLabel.setBounds(DISP_LABEL_X,NAME_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_DisplayNameLabel.setVisible(true);
        m_DisplayNameLabel.setEditable(false);
        return m_DisplayNameLabel;
    }

    /**
     * Gets a created JLabel used to display 'Time Elapsed:'
     * @return a JLabel used with time elapsed
     */
    public JLabel getTimeLabel(){
        m_TimeLabel = new JLabel();
        m_TimeLabel.setText("Time Elapsed: ");
        m_TimeLabel.setVisible(true);
        m_TimeLabel.setBounds(LABEL_X,TIME_Y,LABEL_WIDTH,LABEL_HEIGHT);
        return m_TimeLabel;
  	}

    /**
     * Gets a created JLabel used to display 'Mines Diffused:'
     * @return a JLabel used with mines diffused
     */
	public JLabel getMinesDiffusedLabel(){
        m_MinesDiffusedLabel = new JLabel();
        m_MinesDiffusedLabel.setText("Mines Diffused: ");
        m_MinesDiffusedLabel.setBounds(LABEL_X,MINES_DIFF_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_MinesDiffusedLabel.setVisible(true);
        return m_MinesDiffusedLabel;
    }

    /**
     * Gets a created JLabel used to display 'Mines Present:'
     * @return a JLabel used with mines present on the board
     */
    public JLabel getMinesPresentLabel(){
        m_MinesPresentLabel = new JLabel();
        m_MinesPresentLabel.setText("Mines Present: ");
        m_MinesPresentLabel.setBounds(LABEL_X,MINES_PRES_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_MinesPresentLabel.setVisible(true);
        return m_MinesPresentLabel;
    }

    /**
     * Gets a created JTextField used to display the number of mines present
     * @return a JTextField used with initial number of mines
     * @see GameSetup.java for the getNumberOfMines() method
     */
    public JTextField getDisplayMinesPresentLabel(){
        m_DisplayMinesPresLabel = new JTextField(20);
        m_DisplayMinesPresLabel.setText(GameSetup.getNumberOfMines() + "");
        m_DisplayMinesPresLabel.setBounds(DISP_LABEL_X,MINES_PRES_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_DisplayMinesPresLabel.setEditable(false);
        m_DisplayMinesPresLabel.setVisible(true);
        return m_DisplayMinesPresLabel;
    }

    /**
     * Gets a created JLabel used to display 'Hidden Squares:'
     * @return a JLabel used with hidden squares
     */
    public JLabel getHiddenTilesLabel(){
        m_HiddenTilesLabel = new JLabel();
        m_HiddenTilesLabel.setText("Hidden Squares: ");
        m_HiddenTilesLabel.setBounds(LABEL_X,HIDD_TILES_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_HiddenTilesLabel.setVisible(true);
    	return m_HiddenTilesLabel;
    }

    /**
     * Gets a created JLabel used to display 'Revealed Squares:'
     * @return a JLabel used with squares revealed
     */
    public JLabel getRevealedTilesLabel(){
        m_RevealedTilesLabel = new JLabel();
        m_RevealedTilesLabel.setText("Revealed Squares: ");
        m_RevealedTilesLabel.setBounds(LABEL_X,REV_TILES_Y,LABEL_WIDTH,LABEL_HEIGHT);
        m_RevealedTilesLabel.setVisible(true);
        return m_RevealedTilesLabel;
    }

}