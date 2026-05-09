import java.awt.*;

public class Bullet {

    int x;
    int y;

    int width = 10;
    int height = 5;
    int speed = 10;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }
}
