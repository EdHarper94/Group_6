import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * @file Game.java
 * @author James Michael
 * @date 07 Dec 2015
 * @see GameSetup.java for setter and getter methods
 *
 * This class asks the player for their name and some details 
 * on what settings they would like to use in the game.
 * It also prints everything to the game frame.
 */
public class Game{
    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 450;
    private static final int BOARD_WIDTH = 400;
    private static final int BOARD_HEIGHT = 400;
    private static boolean m_GameStarted = false;
    private static final int DEFAULT_TILES = 10;
    private static final int DEFAULT_MINES = 10;
    private static final int LABEL_WIDTH = 120;
    private static final int LABEL_HEIGHT = 30;
    private static final int LABEL_X = 530;
    private static final int TIME_Y = 100;
    private static final int MINES_DIFF_Y = 160;
    private static final int HIDDEN_TILES_Y = 280;
    private static final int REV_TILES_Y = 340;

    /**
     * Taking one argument and setting whether the game is running.
     * @param gameStarted a boolean argument
     * @return true or false whether the game is in progress.
     */
    private static boolean setIsGameRunning(boolean gameStarted){
        m_GameStarted = gameStarted;
        return m_GameStarted;
    }


    /**
     * Unfortunately this is a lot larger than we wanted, and only takes user
     * input from the command line. We had a lot of problems getting a second
     * GUI window (where the user can input details) to work with our program 
     * without breaking it further.
     */
	public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(false);
            
        Scanner in = new Scanner(System.in);
        boolean gameType = false;
        int enteredNumOfTiles = 0;
        int enteredNumOfMines = 0;
        String name;
        boolean gameInProgress = setIsGameRunning(false);

        /**
         * We did not want this to be here but also did not want to 
         * compromise the stability of the program by using a faulty
         * GUI window to take input which would result in a broken game 
         * upon initialisation of the board later on.
         */
        do{
            System.out.print("Please enter name: ");
            name = in.nextLine();
        }while (name.equals(""));
        System.out.print("Custom game?(y/n) ");
        String customGame = in.nextLine();
        if (customGame.equalsIgnoreCase("y")||customGame.equalsIgnoreCase("yes")){
            gameType = true;
            do {
                System.out.print("Enter number of tiles: ");
                enteredNumOfTiles = in.nextInt();
            }while (enteredNumOfTiles <= 0 || enteredNumOfTiles > 30);
            int totalTiles = enteredNumOfTiles * enteredNumOfTiles;
            do {
                System.out.print("Enter number of mines: ");
                enteredNumOfMines = in.nextInt();
            }while (enteredNumOfMines >= totalTiles || enteredNumOfMines > 150);
        }
        if (customGame.equalsIgnoreCase("n")||customGame.equalsIgnoreCase("no")){
            gameType = false;
            System.out.println("\n**GAME WILL BE PLAYED WITH DEFAULT SETTINGS**");
            enteredNumOfTiles = DEFAULT_TILES;
            enteredNumOfMines = DEFAULT_MINES;
        }

        //This passes the user inputs to the GameSetup class where they are set
        GameSetup setup;
        setup = new GameSetup(name, enteredNumOfTiles, enteredNumOfMines, gameType);
        Counter c = new Counter(enteredNumOfMines, enteredNumOfTiles);
        Time t = new Time();

        gameInProgress = setIsGameRunning(true);

        frame.setVisible(true);
        Board b;
        frame.add(b = new Board());

        /**We wanted to add these to the GameInfo class but resulted in broken counters 
         * being displayed since we display them in a do..while loop below in order to keep
         * the counters up to date as the game plays out. Hence why only these are
         * created here as opposed to the other class.
         */    
        JTextField displayTimeLabel = new JTextField();
        displayTimeLabel.setBounds(LABEL_X,TIME_Y,LABEL_WIDTH,LABEL_HEIGHT);
        displayTimeLabel.setVisible(true);
        displayTimeLabel.setEditable(false);
        
        JTextField displayMinesDiffusedLabel = new JTextField();
        displayMinesDiffusedLabel.setBounds(LABEL_X,MINES_DIFF_Y,LABEL_WIDTH,LABEL_HEIGHT);
        displayMinesDiffusedLabel.setEditable(false);

        JTextField displayHiddenTilesLabel = new JTextField();
        displayHiddenTilesLabel.setBounds(LABEL_X,HIDDEN_TILES_Y,LABEL_WIDTH,LABEL_HEIGHT);
        displayHiddenTilesLabel.setEditable(false);

        JTextField displayRevTilesLabel = new JTextField();
        displayRevTilesLabel.setBounds(LABEL_X,REV_TILES_Y,LABEL_WIDTH,LABEL_HEIGHT);
        displayRevTilesLabel.setEditable(false);

        displayMinesDiffusedLabel.setVisible(true);
        displayHiddenTilesLabel.setVisible(true);
        displayRevTilesLabel.setVisible(true);

        // Gets the labels from GameInfo and adds them to the frame    
        GameInfo info = new GameInfo();
        frame.add(info.getNameLabel());
        frame.add(info.getDisplayNameLabel());
        frame.add(info.getTimeLabel());
        frame.add(info.getMinesDiffusedLabel());
        frame.add(info.getMinesPresentLabel());
        frame.add(info.getDisplayMinesPresentLabel());
        frame.add(info.getHiddenTilesLabel());
        frame.add(info.getRevealedTilesLabel());
        
        b.setSize(BOARD_WIDTH,BOARD_HEIGHT);
        frame.setResizable(false);
        frame.setTitle("Kablewie!");

        /**
         * This keeps the counters up to date by displaying them while
         * the game is running, and collaborates with GameResult to
         * find out when a winning/losing condition has been met.
         */
        GameResult gr = new GameResult();
        do{
            displayTimeLabel.setText(t.getTimeElapsed());
             if(gr.getGameResult() == true) {
                gameInProgress = false;
                String gWon = "You Win!";
                JOptionPane.showMessageDialog(frame, gWon, "You Win!", JOptionPane.WARNING_MESSAGE);

            }
            if(gr.getGameLoss() == true) {
            	gameInProgress = false;
            	String gLost = "You Lose!";
                JOptionPane.showMessageDialog(frame, gLost, "You Lose!", JOptionPane.WARNING_MESSAGE);
            	
            }
            frame.add(displayTimeLabel);

            displayMinesDiffusedLabel.setText(c.getDiffusedCount() + "");
            frame.add(displayMinesDiffusedLabel);

            displayHiddenTilesLabel.setText(c.getTilesRemainingCount() + "");
            frame.add(displayHiddenTilesLabel);

            displayRevTilesLabel.setText(c.getRevealedTileCount() + "");
            frame.add(displayRevTilesLabel);

            gr.setGameResult();
        }while(gameInProgress);

        gameInProgress = setIsGameRunning(false);
        String gameOver = "Game Over!\nThank you for playing Kablewie!";
        JOptionPane.showMessageDialog(frame, gameOver, "Game Over", JOptionPane.WARNING_MESSAGE);
        frame.dispose();
    }
}