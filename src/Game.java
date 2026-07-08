package src;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Game {
    private Player player;
    private Chicken chicken;
    private ArrayList<Path> paths;
    private int currentPath;
    private boolean gameOver;
    public Game(Player player, Chicken chicken) {
        this.player = player;
        this.chicken = chicken;

        paths = new ArrayList<>();
        currentPath = 0;
        gameOver = false;
    }
    public void startGame() {
        paths.clear();
        for (int i = 1; i <= 15; i++) {   //total path 15 wata xa ((limited pathss))
            paths.add(new Path(i));
        }
        currentPath = 0;
        gameOver = false;            
        System.out.println("Game Started!");
    }
    public void jump() {
    if(gameOver)
        return;
    currentPath++;
    chicken.move(105);
if (currentPath >= paths.size()) {

    JOptionPane.showMessageDialog(null, " You Win!"+player.getBalance());
    startGame();
    chicken.setX(50);
    chicken.setY(395);
    currentPath = 0;
    gameOver = false;

    return;
}

    Path current = paths.get(currentPath);

    if (current.hasFire()) {

    JOptionPane.showMessageDialog(null, "Game Over!");

    startGame();
    chicken.setX(50);
    chicken.setY(395);
    currentPath = 0;
    gameOver = false;
    return;
}
}
    public void cashOut() {
        if (gameOver) {
            return;
        }
        if (currentPath == 0) {
            System.out.println("Cannot withdraw");
            return;
        }
        Path current = paths.get(currentPath - 1);
        double won = player.getBalance() * current.getMultiplier();
        System.out.println("You won " + won);
    }
    public ArrayList<Path> getPaths() {
        return paths;
    }
       public Chicken getChicken() {
    return chicken;
}

    public boolean isGameOver() {
        return gameOver;
    }
}