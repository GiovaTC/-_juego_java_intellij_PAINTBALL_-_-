import java.awt.*;
import java.util.Random;

public class Enemy {

    int x;
    int y;

    int width = 40;
    int height = 40;

    int speed = 3;

    Random random = new Random();

    public Enemy(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public void move() {

        x -= speed;

    }

    public void draw(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);

    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);

    }

}
