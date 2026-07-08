package src;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Game {

    private Player player;
    private Chicken chicken;
    private ArrayList<Path> paths;  //multiple paths ko lagi arraylist banako

    private int currentPath;
    private boolean gameOver;
    private int firePathIndex;

    public Game(Player player, Chicken chicken) {
        this.player = player;
        this.chicken = chicken;

        paths = new ArrayList<>();
        currentPath = 0;
        gameOver = false;
        firePathIndex = -1;
    }

    public void startGame() {

        paths.clear();

        for (int i = 1; i <= 15; i++) {   //15 wata path
            paths.add(new Path(i));
        }

        currentPath = 0;
        gameOver = false;
        firePathIndex = -1;// path jump garepaxi decrease huncha i.e first path gayo vaney 14 path baki huncha and so on
    }

    public void jump() {

        if (gameOver)
            return;

        currentPath++;
        chicken.move(105);

        if (currentPath >= paths.size()) {

            JOptionPane.showMessageDialog(null, " You Won!"+ getPlayer().getCurrentBet() * paths.get(paths.size() - 1).getMultiplier());

            startGame();

            chicken.setX(50);
            chicken.setY(395);

            return;
        }

        Path current = paths.get(currentPath);

        if (current.hasFire()) {

            firePathIndex = currentPath;
            gameOver = true;
        }
    }

    public void cashOut() {

        if (gameOver)
            return;

        if (currentPath == 0) {
            JOptionPane.showMessageDialog(null,
                    "Jump at least one path");
            return;
        }

        Path current = paths.get(currentPath - 1);

        double won = player.getCurrentBet() * current.getMultiplier();

        player.setBalance(player.getBalance() + won);

        JOptionPane.showMessageDialog(null, "YouWon: " + won);

        startGame();

        chicken.setX(50);
        chicken.setY(395);
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public Player getPlayer() {
        return player;
    }

    public int getCurrentPath() {
        return currentPath;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getFirePathIndex() {
        return firePathIndex;
    }
}