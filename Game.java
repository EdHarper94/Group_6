import java.util.Calendar;
import java.util.Scanner;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.awt.FlowLayout;

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
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 600;
    private boolean gameStarted = false;
    private JTextField nameTF;
    public final int TEXT_FIELD_WIDTH = 10;

    public static boolean isGameRunning(boolean gameStarted){
        return gameStarted;
    }

	public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        /*frame.setTitle("Kablewie!");
        String welcome = "Welcome to Kablewie!\nLet's set up a game...";
        JOptionPane.showMessageDialog(frame, welcome, "Kablewie! - Game Setup", JOptionPane.WARNING_MESSAGE);*/
            
        Scanner in = new Scanner(System.in);
        String playerName;
        int numberOfTiles = 0;
        int numberOfMines = 0;
        String time;
        boolean gameType;
        int enteredNumOfTiles = 0;
        int enteredNumOfMines = 0;

        boolean gameStarted = isGameRunning(false);
        System.out.println("GAME IS IN PROGRESS: " + gameStarted);
        System.out.print("Please enter name: ");
        String name = in.nextLine();
        System.out.print("Custom game?(y/n) ");
        String customGame = in.nextLine();
        if (customGame.equalsIgnoreCase("y")||customGame.equalsIgnoreCase("yes")){
            gameType = true;
            System.out.print("Enter number of tiles: ");
            enteredNumOfTiles = in.nextInt();
            System.out.print("Enter number of mines: ");
            enteredNumOfMines = in.nextInt();
        }
        else {
            gameType = false;
            System.out.println("\n**GAME WILL BE PLAYED WITH DEFAULT SETTINGS**");
            enteredNumOfTiles = 10;
            enteredNumOfMines = 10;
        }

        GameSetup setup = new GameSetup(name, enteredNumOfTiles, enteredNumOfMines, gameType);
        Time t = new Time();
        //Board b = new Board();
        playerName = setup.getName();
        time = t.getCurrentTime();
        boolean selectedGameType = setup.getGameType();
        int boardSize = setup.getNumberOfTiles();
        int totalMines = setup.getNumberOfMines();
        int totalBoardSize = boardSize*boardSize;

        gameStarted = isGameRunning(true);

        System.out.println("\n**NAME: " + playerName + "\n\n**CUSTOM GAME: " + selectedGameType + "\n\n**SIZE OF BOARD: " + totalBoardSize + " (" + boardSize +
                            "x" + boardSize + ")\n\n**NUMBER OF MINES: " + totalMines); // + "\n\n**TIME (work in progress **IGNORE**): " + time);
        frame.setVisible(true);
        frame.setTitle("Kablewie!");
        //String defaultSettings = "**GAME WILL BE PLAYED WITH DEFAULT SETTINGS**";
        String welcome = "**NAME: " + playerName + "\n**CUSTOM GAME: " + selectedGameType + "\n**TOTAL SIZE OF BOARD: " + totalBoardSize + " (" + boardSize +
                            "x" + boardSize + ")\n**NUMBER OF MINES: " + totalMines; //+ "\n**TIME (work in progress **IGNORE**): " + time;
        //String defaultWelcome = defaultSettings + "\n\n" + welcome;
        /*if (gameType == false){
            JOptionPane.showMessageDialog(frame, defaultWelcome, "Welcome to Kablewie!", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, welcome, "Welcome to Kablewie!", JOptionPane.WARNING_MESSAGE);
        }*/
        JOptionPane.showMessageDialog(frame, welcome, "Welcome to Kablewie!", JOptionPane.WARNING_MESSAGE);
        System.out.println("GAME IS IN PROGRESS: " + gameStarted);
        //gameStarted = isGameRunning(false);
        //System.out.println("GAME IS IN PROGRESS: " + gameStarted);
        /*do{
            //currentTime = new SimpleDateFormat("HH:mm:ss").format(timerStart.getTime());
            System.out.println(Time.getCurrentTime());
        }while(gameStarted = isGameRunning(true));
        gameStarted = isGameRunning(false);*/

    }
}
/*public class GameGUI extends JFrame{
    public final boolean setNameTF(JTextField playerNameTF){
      boolean test = true;
       nameTF = playerNameTF;
       return true;
   }

   public JTextField getNameTF(){
       return nameTF;
   }

   //public Game(){
    //    this.setLayout( new FlowLayout() ); // set frame layout

      /** construct textfield with TEXT_FIELD_WIDTH columns */
   //   this.setNameTF(new JTextField( TEXT_FIELD_WIDTH ));
      /** add textField1 to JFrame */
   //   this.add( this.getNameTF() );
   //}  

//}