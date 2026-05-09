import java.awt.*;

public class Player {

    int x;
    int y;

    int width = 40;
    int height = 40;
    int speed = 5;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);

    }
}
