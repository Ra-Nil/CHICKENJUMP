package src;
public class Chicken {
    private double x, y, width, height;
    private boolean isJumping;
    public Chicken(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isJumping = false;
    }
    public void jump() {
        if ( isJumping == true) {
            System.out.println("Jumped");
        }
    }
    public void move(double distance) {
        this.x += distance;
    }
    public void setX(double x) {
    this.x = x;
}

public void setY(double y) {
    this.y = y;
}
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public boolean isJumping() {
        return isJumping;
    }

    }
