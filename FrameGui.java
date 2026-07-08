import javax.swing.*;
import src.Game;
class FrameGUI extends JFrame {
    private Game game;

    public FrameGUI(Game game) {
        this.game = game;

        setTitle("Chicken Jump");

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelGUI panel = new PanelGUI(game);
        add(panel);
        panel.requestFocusInWindow();

        setVisible(true);

    }

}