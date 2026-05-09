import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    final int WIDTH = 900;
    final int HEIGHT = 600;

    Timer timer;

    Player player;

    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();

    Random random = new Random();
    int score = 0;

    GamePanel() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        player = new Player(100, 250);
        timer = new Timer(20, this);
        timer.start();
    }

    public void spawnEnemy() {

        int y = random.nextInt(500);
        enemies.add(new Enemy(850, y));
    }   
}
