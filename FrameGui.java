import java.awt.*;
import javax.swing.*;
import src.Game;

public class FrameGUI extends JFrame {

    private Game game;

    private JLabel balanceLabel;
    private JLabel betLabel;
    private JLabel multiplierLabel;
    private JButton cashOutButton;
    private PanelGUI panel;

    public FrameGUI(Game game) {

        this.game = game;

        setTitle("Chicken Jump");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        balanceLabel = new JLabel("Balance: " + game.getPlayer().getBalance());
        betLabel = new JLabel("Bet: " + game.getPlayer().getCurrentBet());
        multiplierLabel = new JLabel("Multiplier: x1.00");

        cashOutButton = new JButton("Cash Out");
        cashOutButton.setFocusable(false); // Prevent Space bar from clicking button

        cashOutButton.addActionListener(e -> {
            game.cashOut();

            // close gardinxa entire program window
            dispose();

            //feri pahila firsst ko screen display garxa 
            new BetGUI(game.getPlayer());

        });
        JPanel bottom = new JPanel();

        bottom.add(balanceLabel);
        bottom.add(betLabel);
        bottom.add(multiplierLabel);
        bottom.add(cashOutButton);

        panel = new PanelGUI(game, this);

        setLayout(new BorderLayout());

        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);

        // Give keyboard focus to game panel
        SwingUtilities.invokeLater(() -> panel.requestFocusInWindow());
    }


    public void updateBalance() {
        balanceLabel.setText("Balance: $" + game.getPlayer().getBalance());
    }

    public void updateMultiplier() {

        if (game.getCurrentPath() == 0) {
            multiplierLabel.setText("Multiplier: x1.00");
            return;
        }

        double multiplier =game.getPaths() .get(game.getCurrentPath() - 1) .getMultiplier();

        multiplierLabel.setText("Multiplier: x" + multiplier);
    }
}