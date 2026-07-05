package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JOptionPane.showMessageDialog(this,"Bet Successful!"
        );
        balanceLabel.setText("Available Balance: $" + player.getBalance());

        //exception dinxa message popup huncha
    } catch (Invalidbetexception | InsufficientbalanceException ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE
        );

    }
});
        startButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setText("Starting......");
            }
        });;
           startButton.addActionListener(e -> {
               startGame();
               });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        panel.add(balanceLabel);
        panel.add(betField);
        panel.add(betButton);
        panel.add(startButton);
        add(panel);

        setVisible(true);
    }

    private void startGame() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }
}
