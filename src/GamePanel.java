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

    @Override
    public void actionPerformed(ActionEvent e) {

        if(random.nextInt(100) < 3) {

            spawnEnemy();

        }

        for(Bullet bullet : bullets) {

            bullet.move();

        }

        for(Enemy enemy : enemies) {

            enemy.move();

        }

        checkCollisions();

        repaint();

    }

    public void checkCollisions() {

        Iterator<Bullet> bulletIterator = bullets.iterator();

        while(bulletIterator.hasNext()) {

            Bullet bullet = bulletIterator.next();

            Iterator<Enemy> enemyIterator = enemies.iterator();

            while(enemyIterator.hasNext()) {

                Enemy enemy = enemyIterator.next();

                if(bullet.getBounds().intersects(enemy.getBounds())) {

                    bulletIterator.remove();
                    enemyIterator.remove();

                    score += 10;

                    break;

                }

            }

        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        for(Bullet bullet : bullets) {

            bullet.draw(g);

        }

        for(Enemy enemy : enemies) {

            enemy.draw(g);

        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));

        g.drawString("SCORE: " + score, 20, 40);

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP) {

            player.y -= player.speed;

        }

        if(key == KeyEvent.VK_DOWN) {

            player.y += player.speed;

        }

        if(key == KeyEvent.VK_LEFT) {

            player.x -= player.speed;

        }

        if(key == KeyEvent.VK_RIGHT) {

            player.x += player.speed;

        }

        if(key == KeyEvent.VK_SPACE) {

            bullets.add(
                    new Bullet(
                            player.x + 40,
                            player.y + 20
                    )
            );

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
