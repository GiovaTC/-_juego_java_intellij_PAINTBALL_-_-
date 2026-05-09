# -_juego_java_intellij_PAINTBALL_-_- :.
🎯 Juego JAVA IntelliJ — PAINTBALL:

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/1cd1099f-163e-47ac-a117-58add6761a38" />  

```
Proyecto completo desarrollado en Java + Swing para IntelliJ IDEA .

Incluye:

✅ Interfaz gráfica
✅ Movimiento del jugador
✅ Disparos Paintball
✅ Enemigos automáticos
✅ Sistema de puntuación
✅ Colisiones
✅ Arquitectura básica orientada a objetos
✅ Estilo arcade 2D.

📁 Estructura del Proyecto
PAINTBALL_GAME/
│
├── src/
│   ├── Main.java
│   ├── GameFrame.java
│   ├── GamePanel.java
│   ├── Player.java
│   ├── Bullet.java
│   └── Enemy.java

1️⃣ Main.java
public class Main {

    public static void main(String[] args) {

        new GameFrame();

    }

}

2️⃣ GameFrame.java
import javax.swing.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    GameFrame() {

        panel = new GamePanel();

        this.add(panel);

        this.setTitle("PAINTBALL GAME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}

3️⃣ Player.java
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

4️⃣ Bullet.java
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

5️⃣ Enemy.java
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

6️⃣ GamePanel.java
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

▶️ Cómo Ejecutarlo en IntelliJ IDEA
1. Crear Proyecto
File
→ New Project
→ Java
→ Crear proyecto

2. Crear Archivos
Dentro de src crear:
Main.java
GameFrame.java
GamePanel.java
Player.java
Bullet.java
Enemy.java

3. Ejecutar
Ejecutar:
Main.java

🎮 Controles
Tecla	Acción
↑	Mover arriba
↓	Mover abajo
←	Mover izquierda
→	Mover derecha
SPACE	Disparar

🧠 Mejoras que Puedes Agregar
Nivel Intermedio
Música
Sonidos
Pantalla Game Over
Vidas
Power Ups
Menú principal
Fondo animado
Diferentes armas
Explosiones.

🚀 Versión Profesional (Ideas)
Puedes evolucionarlo a:
JavaFX
Multiplayer Socket TCP
Base de datos Oracle/MySQL
Ranking de jugadores
Login de usuarios
Motor 2D
Sprites PNG
Colisiones avanzadas.

🎨 Diseño Visual Recomendado
Elemento	Diseño
Jugador	Azul
Paintball Gun	Integrada
Enemigos	Rojos
Movimiento	Aleatorio
Fondo	Arena Paintball
Obstáculos	Muros .

🏁 Resultado Final
El juego tendrá:
✅ Movimiento
✅ Disparos
✅ Enemigos
✅ Colisiones
✅ Puntaje
✅ Interfaz gráfica Java Swing
✅ Arquitectura orientada a objetos.

📌 Tecnologías Utilizadas
Java SE
Swing GUI
POO (Programación Orientada a Objetos)
IntelliJ IDEA.

🎯 Tipo de Juego
Arcade 2D
Paintball Shooter
Single Player :. . / .
