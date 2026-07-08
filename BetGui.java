import java.awt.*;
import javax.swing.*;
import src.Chicken;
import src.Game;
import src.InsufficientbalanceException;
import src.Invalidbetexception;
import src.Player;

public class BetGUI extends JFrame {

    private JLabel balanceLabel;
    private JTextField betField;
    private JButton betButton;
    private JButton startButton;

    private Player player;

    public BetGUI() {

        player = new Player(1000);

        setTitle("Chicken Jump");
        setSize(450,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        balanceLabel = new JLabel("Available Balance: $" + player.getBalance());
        betField = new JTextField();
        betButton = new JButton("Place Bet");
        startButton = new JButton("Start Game");
        betButton.addActionListener(e -> placeBet());

        startButton.addActionListener(e -> startGame());

        JPanel panel = new JPanel(new GridLayout(6,1,10,10));
        panel.add(balanceLabel);
        panel.add(betField);
        panel.add(betButton);
        panel.add(startButton);
        add(panel);
        setVisible(true);
    }

    private void placeBet() {

        try {
            double bet = Double.parseDouble(betField.getText());
            player.placeBet(bet);
            balanceLabel.setText("Available Balance: $" + player.getBalance());
            JOptionPane.showMessageDialog(this,"Bet Successful!");
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Enter a valid number.");

        }
        catch(Invalidbetexception | InsufficientbalanceException ex){
            JOptionPane.showMessageDialog(this,ex.getMessage());

        }

    }
    private void startGame(){

        dispose();     //recent  frame program gui off gardinxa//
        Chicken chicken = new Chicken(50,395,50,50);
        Game game = new Game(player,chicken);

        new FrameGUI(game); /// naya gameframe  dinxa

    }

}