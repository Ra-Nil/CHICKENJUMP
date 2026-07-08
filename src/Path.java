package src;
import java.util.Random;
public class Path {
    private int pathNum;
    private double multiplier;
    private boolean fire;
    private static Random random = new Random();   //random fire generate garxa path hauruma
    public Path(int pathNum) {
        this.pathNum = pathNum;
        this.multiplier = 1.0 + (pathNum * 1.25);
        this.fire = random.nextBoolean();        //fire xa ki xaina random generate garxa
    }
    public int getPathNum() {
        return pathNum;
    }
    public double getMultiplier() {
        return multiplier;
    }
    public boolean hasFire() {
        return fire;
    }
    public void setFire(boolean fire) {
        this.fire = fire;
    }
    public void displayPath() {
        System.out.println("Path " + pathNum);
        System.out.println("Multiplier: " + multiplier + "x");

        if (fire==true) {
            System.out.println("GameOver");
        }
    }
}