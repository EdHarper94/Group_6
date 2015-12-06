import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameInfo{
	//private static JLabel nameLabel;
	public static JLabel getNameLabel(){
		JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        nameLabel.setBounds(420,40,120,30);
        nameLabel.setVisible(true);
        return nameLabel;
  	}
	
	public static JTextField getDisplayNameLabel(){
		JTextField displayNameLabel = new JTextField(20);
        displayNameLabel.setText(GameSetup.getName());
        displayNameLabel.setBounds(530,40,120,30);
        displayNameLabel.setVisible(true);
        displayNameLabel.setEditable(false);
        return displayNameLabel;
    }

    public static JLabel getTimeLabel(){
		JLabel timeLabel = new JLabel();
        timeLabel.setText("Time Elapsed: ");
        timeLabel.setVisible(true);
        timeLabel.setBounds(420,100,120,30);
        return timeLabel;
  	}
	public static JLabel getMinesDiffusedLabel(){
		JLabel minesDiffusedLabel = new JLabel();
        minesDiffusedLabel.setText("Mines Diffused: ");
        minesDiffusedLabel.setBounds(420,160,120,30);
        minesDiffusedLabel.setVisible(true);
        return minesDiffusedLabel;
    }

    public static JLabel getMinesPresentLabel(){
    	JLabel minesPresentLabel = new JLabel();
        minesPresentLabel.setText("Mines Present: ");
        minesPresentLabel.setBounds(420,220,120,30);
        minesPresentLabel.setVisible(true);
        return minesPresentLabel;
    }

    public static JTextField getDisplayMinesPresentLabel(){
    	JTextField displayMinesPresentLabel = new JTextField(20);
        displayMinesPresentLabel.setText(GameSetup.getNumberOfMines() + "");
        displayMinesPresentLabel.setBounds(530,220,120,30);
        displayMinesPresentLabel.setEditable(false);
        displayMinesPresentLabel.setVisible(true);
        return displayMinesPresentLabel;
    }

    public static JLabel getHiddenTilesLabel(){
    	JLabel hiddenTilesLabel = new JLabel();
    	hiddenTilesLabel.setText("Hidden Squares: ");
    	hiddenTilesLabel.setBounds(420,280,120,30);
    	hiddenTilesLabel.setVisible(true);
    	return hiddenTilesLabel;
    }

    public static JLabel getRevealedTilesLabel(){
    	JLabel revealedTilesLabel = new JLabel();
        revealedTilesLabel.setText("Revealed Squares: ");
        revealedTilesLabel.setBounds(420,340,120,30);
        revealedTilesLabel.setVisible(true);
        return revealedTilesLabel;
    }
	/*public static JTextField getDisplayTimeLabel(){
        JTextField displayTimeLabel = new JTextField(20);
        displayTimeLabel.setBounds(530,100,120,30);
        //Time t = new Time();
        //displayTimeLabel.setText(t.getTimeElapsed());
        displayTimeLabel.setVisible(true);
        return displayTimeLabel;
    }*/
}