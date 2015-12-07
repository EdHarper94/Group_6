import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * @file Game.java
 * @author James Michael
 * @date 02 Dec 2015
 * @see GameSetup.java for setter and getter methods
 *
 * This class asks the player for their name and some details 
 * on what settings they would like to use in the game.
 */
public class Game{
    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 450;
    private static boolean gameStarted = false;

    public static boolean isGameRunning(boolean gameStarted){
        return gameStarted;
    }

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

        boolean gameStarted = isGameRunning(false);
        System.out.println("GAME IS IN PROGRESS: " + gameStarted);

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
            enteredNumOfTiles = 10;
            enteredNumOfMines = 10;
        }

        GameSetup setup = new GameSetup(name, enteredNumOfTiles, enteredNumOfMines, gameType);
        Counter c = new Counter(enteredNumOfMines, enteredNumOfTiles);
        Time t = new Time();

        gameStarted = isGameRunning(true);

        frame.setVisible(true);
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



        frame.setTitle("Kablewie!");

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
            displayMinesDiffusedLabel.setText(c.getDiffusedCount() + "");
            frame.add(displayMinesDiffusedLabel);
            displayHiddenTilesLabel.setText(c.getTilesRemainingCount() + "");
            frame.add(displayHiddenTilesLabel);
            displayRevealedTilesLabel.setText(c.getRevealedTileCount() + "");
            frame.add(displayRevealedTilesLabel);
            gr.setGameResult();
 
        }while(gameStarted);

        gameStarted = isGameRunning(false);
        String gameOver = "Game Over!\nThank you for playing Kablewie!";
        JOptionPane.showMessageDialog(frame, gameOver, "Game Over", JOptionPane.WARNING_MESSAGE);
        frame.dispose();

    }
}