import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import src.Game;
import src.Path;

public class PanelGUI extends JPanel {

    private Game game;
    private FrameGUI frame;

    private Image chickenImg;
    private Image fireImg;

    public PanelGUI(Game game, FrameGUI frame) {

        this.game = game;
        this.frame = frame;

        // Load images
        chickenImg = new ImageIcon("assets/chicken.png").getImage();
        fireImg = new ImageIcon("assets/fire.png").getImage();

        // Background color
        setBackground(new Color(135, 206, 235));

        // Receive keyboard input
        setFocusable(true);

        // ==========================
        // Space Bar = Jump
        // ==========================
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                    // Chicken jumps
                    game.jump();

                    // Update game information
                    frame.updateMultiplier();
                    frame.updateBalance();

                    // Redraw game
                    repaint();

                    // Game Over
                    if (game.isGameOver()) {

                        JOptionPane.showMessageDialog( PanelGUI.this,"🔥 Game Over!"
                        );

                        // Close game window
                        SwingUtilities.getWindowAncestor(PanelGUI.this).dispose();

                        // Return to betting screen
                       new BetGUI(game.getPlayer());
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int startX = 50;
        int startY = 450;
        int pathWidth = 80;
        int pathHeight = 20;
        int gap = 25;

        // ==========================
        // Draw Paths
        // ==========================
        for (int i = 0; i < game.getPaths().size(); i++) {

            Path path = game.getPaths().get(i);

            int x = startX + i * (pathWidth + gap);

            // Draw path
            g.setColor(new Color(139, 69, 19));
            g.fillRect(x, startY, pathWidth, pathHeight);

            // Show fire only on the path the player hit
            if (game.isGameOver() && i == game.getFirePathIndex()) {

                g.drawImage(
                        fireImg,
                        x + 20,
                        startY - 40,
                        40,
                        40,
                        this
                );
            }
        }

        // ==========================
        // Draw Chicken
        // ==========================
        g.drawImage(
                chickenImg,
                (int) game.getChicken().getX(),
                (int) game.getChicken().getY(),
                50,
                50,
                this
        );
    }
}