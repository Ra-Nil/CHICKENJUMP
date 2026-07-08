import java.awt.*;
import javax.swing.*;
import src.Chicken;
import src.Game;
import src.InsufficientbalanceException;
import src.Invalidbetexception;
import src.Player;


public class GameGUI extends JFrame {

    private JLabel balanceLabel;
    private JTextField betField;
    private JButton betButton;
    private JButton startButton;
    private Player player = new Player(1000);
    public GameGUI() {

        setTitle("Chicken Jump");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        balanceLabel = new JLabel("Available Balance: $1000");
        betField = new JTextField(10);
        betButton = new JButton("Place Bet");


        startButton = new JButton("Start Game");
//balance check garxa player.java bata
      betButton.addActionListener(e -> {
          try {
              double bet = Double.parseDouble(betField.getText());
              player.placeBet(bet);
              JOptionPane.showMessageDialog(this, "Bet Successful!");
              balanceLabel.setText("Available Balance: $" + player.getBalance());
          } catch (Invalidbetexception | InsufficientbalanceException ex) {
              JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                      JOptionPane.ERROR_MESSAGE);
          }
      });

        startButton.addActionListener(e -> {
            startButton.setText("Starting......");
            startGame();
        });


               
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        class gamePanel extends JPanel {
           public gamePanel() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ground
        g.setColor(new Color(50, 180, 50));
        g.fillRect(0, 500, getWidth(), 100);

        // Chicken (temporary)
        g.setColor(Color.YELLOW);
        g.fillOval(100, 430, 50, 50);

        g.setColor(Color.BLACK);
        g.drawString("Chicken Game", 20, 30);
    }
        }




        panel.add(balanceLabel);
        panel.add(betField);
        panel.add(betButton);
        panel.add(startButton);
        add(panel);

        setVisible(true);
    }

    private void startGame() {
        dispose();
        Chicken chicken = new Chicken(0.0, 0.0, 50.0, 50.0);
        Game game = new Game(player, chicken);
        new GameFrame(game); 
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
