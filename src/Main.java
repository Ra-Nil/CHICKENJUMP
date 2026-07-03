package src;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player(1000);
        Chicken chicken = new Chicken(100, 300, 50, 50);
        Game game = new Game(player, chicken);
        
        while (true) {
            System.out.print("Enter bet amount: ");
            double betAmount = sc.nextDouble();
            try {
                player.placeBet(betAmount);
                break;
            } catch (Invalidbetexception e) {
                System.out.println(e.getMessage());
            } catch (InsufficientbalanceException e) {
                System.out.println(e.getMessage());
            }
        }
        game.startGame();
        game.jump();
        game.jump();
        game.jump();
        game.cashOut();
        sc.close();
    }
}
