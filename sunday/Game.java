import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class Game{
	private static final int TEXT_FIELD_WIDTH = 15;
    private static final int FRAME_WIDTH = 200;
    private static final int FRAME_HEIGHT = 200;
    private static JTextField m_NameTF;
    private static JTextField m_NumOfTilesTF;
    private static JTextField m_NumOfMinesTF;
    private static JButton m_ConfirmJB;

    private static JTextField getNameTF() {
        return m_NameTF;
    }

    private static void setNameTF(JTextField nameTF) {
        m_NameTF = nameTF;
    }

    private static JTextField getNumOfTilesTF() {
        return m_NumOfTilesTF;
    }

    private static void setNumOfTilesTF(JTextField numOfTilesTF) {
        m_NumOfTilesTF = numOfTilesTF;
    }

    private static JTextField getNumOfMinesTF() {
        return m_NumOfMinesTF;
    }

    private static void setNumOfMinesTF(JTextField numOfMinesTF) {
        m_NumOfMinesTF = numOfMinesTF;
    }

    private static JButton getConfirmJB() {
        return m_ConfirmJB;
    }

    private static void setConfirmJB(JButton confirmJB) {
        m_ConfirmJB = confirmJB;
    }

    public static void main(String[] args){

        JFrame startup = new JFrame();
        startup.setTitle("Kablewie!");
        startup.setLayout(new FlowLayout()); // set frame layout


        /** construct textfield with TEXT_FIELD_WIDTH columns */
        //Time t = new Time();
        //startup.setLayout(null);
        startup.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //startup.setResizable(false);
        //this.getContentPane().setLayout(null);


        startup.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setNameTF(new JTextField("Enter name", TEXT_FIELD_WIDTH));
        setNumOfTilesTF(new JTextField("Enter number of Tiles", TEXT_FIELD_WIDTH));
       	setNumOfMinesTF(new JTextField("Enter number of Mines", TEXT_FIELD_WIDTH));
        setConfirmJB(new JButton("Confirm"));
        //this.setNameTF().setText("sda");
        //this.setNameTF().setText(t.getTimeElapsed());
        /** add textField1 to JFrame */
        //do{
        //this.add(this.getNumOfTilesTF());
        startup.add(getNameTF());
        startup.add(getNumOfTilesTF());
        startup.add(getNumOfMinesTF());
        startup.add(getConfirmJB());
        startup.setVisible(true);
        GameWindowHandler handler = new GameWindowHandler();
        //this.getNameTF().addActionListener( handler );
        getNameTF().addMouseListener(handler);
        //this.getNumOfTilesTF().addActionListener( handler );
        getNumOfTilesTF().addMouseListener(handler);
        //this.getNumOfMinesTF().addActionListener( handler );
        getNumOfMinesTF().addMouseListener(handler);
        getConfirmJB().addActionListener(handler);
        //this.setVisible(false);
        //this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        //}while(Game.isGameRunning(true));
    }

    private static class GameWindowHandler implements ActionListener, MouseListener {

        /**
         * Process textfield events.
         * The actionPerformed() method is defined in the
         * ActionListener interface.
         */
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == getNameTF()) {
                getNameTF().setText("");
            }
            if (e.getSource() == getNumOfTilesTF()) {
                getNumOfTilesTF().setText("");
            }
            if (e.getSource() == getNumOfMinesTF()) {
                getNumOfMinesTF().setText("");
            }
          /*if(e.getSource() == getNameTF()){
      		getNameTF().setText("");
      	}*/
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }


        public void actionPerformed(ActionEvent event) {

            /** local testing variable */
            //boolean test = true;
            /** Declare string to display */
            String string = "";
            String name = "";
            int numberOfTiles = 0;
            int numberOfMines = 0;
            //while (numberOfMines == 0) {
                try {
                    name = getNameTF().getText();
                    numberOfMines = Integer.parseInt(getNumOfMinesTF().getText());
                    numberOfTiles = Integer.parseInt(getNumOfTilesTF().getText());
                    GameSetup setup = new GameSetup(name, numberOfTiles, numberOfMines, true);
                    String test = "Name: " + setup.getName() + "\nNumOfTiles: " + setup.getNumberOfTiles() + "\nNumOfMines: " + setup.getNumberOfMines();
                    JOptionPane.showMessageDialog(null, test);
                    GameWindow main = new GameWindow();
                    //Game g = new Game();
                    //g.isGameRunning(true);
                    //Board b;
                    //GameWindow.add(b = new Board());
                    //setVisible(false);
                    //Board b;
                    //Game game = new Game();
                    //game.add(b = new Board());
                    //game.setVisible(true);
                    //Game.frame.setVisible(true);
                } catch (NumberFormatException e)   {
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid number");
                }
            //}

            //if (test) {
            //    System.out.println("TextFieldFrameProper::actionPerformed()");
            //System.out.println("event is: " + event.toString() );
            //}
            /**
             * User pressed Enter in JTextField textField1.
             * When that event happens, this method is called.
             */

            //string = String.format( "textField1: %s", event.getActionCommand() );

        }
    }
}