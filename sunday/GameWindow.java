import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class GameWindow{
	private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 450;
    private static boolean gameStarted = false;

    public static boolean isGameRunning(boolean gameStarted){
        return gameStarted;
    }

	public GameWindow(){
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        //frame.setVisible(false);
          
        boolean gameStarted = isGameRunning(false);
        //isGamez
        //System.out.println("GAME IS IN PROGRESS: " + gameStarted);

        //Counter c = new Counter(GameSetup.getNumberOfMines(),GameS);
        Time t = new Time();

        gameStarted = isGameRunning(true);

        Board b;
        frame.add(b = new Board());

        JTextField displayTimeLabel = new JTextField(20);
        displayTimeLabel.setBounds(530,100,120,30);
        displayTimeLabel.setVisible(true);
        displayTimeLabel.setEditable(false);
        
        JTextField displayMinesDiffusedLabel = new JTextField(20);
        displayMinesDiffusedLabel.setBounds(530,160,120,30);
        displayMinesDiffusedLabel.setEditable(false);

        JTextField displayHiddenTilesLabel = new JTextField(20);
        displayHiddenTilesLabel.setBounds(530,280,120,30);
        displayHiddenTilesLabel.setEditable(false);

        JTextField displayRevealedTilesLabel = new JTextField(20);
        displayRevealedTilesLabel.setBounds(530,340,120,30);
        displayRevealedTilesLabel.setEditable(false);

        GameInfo info = new GameInfo();
        frame.add(info.getNameLabel());
        frame.add(info.getDisplayNameLabel());
        frame.add(info.getTimeLabel());
        frame.add(info.getMinesDiffusedLabel());
        frame.add(info.getMinesPresentLabel());
        frame.add(info.getDisplayMinesPresentLabel());
        frame.add(info.getHiddenTilesLabel());
        frame.add(info.getRevealedTilesLabel());
        
        displayMinesDiffusedLabel.setVisible(true);
        displayHiddenTilesLabel.setVisible(true);
        displayRevealedTilesLabel.setVisible(true);

        b.setSize(400,400);

        frame.setResizable(false);


        //frame.setVisible(true);
        frame.setTitle("Kablewie!");
        gameStarted = true;
        GameResult gr = new GameResult();
        do{

            displayTimeLabel.setText(t.getTimeElapsed());
             if(gr.getGameResult() == true){
                gameStarted = false;
                String gameWon = "You Win!";
                JOptionPane.showMessageDialog(frame, gameWon, "You Win!", JOptionPane.WARNING_MESSAGE);

            }
            if(gr.getGameLoss() == true){
            	gameStarted = false;
            	String gameLost = "You Lose!";
                JOptionPane.showMessageDialog(frame, gameLost, "You Lose!", JOptionPane.WARNING_MESSAGE);
            	
            }
            frame.add(displayTimeLabel);
            displayMinesDiffusedLabel.setText(Counter.getDiffusedCount() + "");
            frame.add(displayMinesDiffusedLabel);
            displayHiddenTilesLabel.setText(Counter.getTilesRemainingCount() + "");
            frame.add(displayHiddenTilesLabel);
            displayRevealedTilesLabel.setText(Counter.getRevealedTileCount() + "");
            frame.add(displayRevealedTilesLabel);
            frame.setVisible(true);
            gr.setGameResult();
 
        }while(gameStarted);

        gameStarted = isGameRunning(false);
        String gameOver = "Game Over!\nThank you for playing Kablewie!";
        JOptionPane.showMessageDialog(frame, gameOver, "Game Over", JOptionPane.WARNING_MESSAGE);
        frame.dispose();

    }
}