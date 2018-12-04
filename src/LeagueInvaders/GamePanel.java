package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
    public static  BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	// GameObject Gobject;
	ObjectManager manager;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		// Gobject = new GameObject(10,10,10,10);
		timer.start();
		manager = new ObjectManager(rocket);
        try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(rocket.isAlive == false) {
			currentState = END_STATE;
			//System.out.println("test");
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start", 100, 200);
		g.setFont(titleFont);
		g.drawString("Legue Invaders", 100, 100);
	}

	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
		//g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		g.setColor(Color.BLACK);
		g.drawString("You killed " + manager.getScore() + " enemies", 100, 200);
		g.drawString("Your high score is " + manager.getHighScore() + " enemies", 100, 220);
		g.setFont(titleFont);
		g.drawString("Game Over", 100, 100);

	}

	@Override
	public void paintComponent(Graphics g) {
		// g.fillRect(10, 10, 100, 100);
		// Gobject.draw(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Gobject.update();
		//System.out.println("SCORE = " + manager.getScore());
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("testT");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("testP");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
				rocket = new Rocketship(250, 700, 50, 50);
			manager = new ObjectManager(rocket);	
			}
		}
		if(rocket.x >= 0 && rocket.x <= 500 && rocket.y >= 0 && rocket.y <= 800) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.goRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.goLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.goUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.goDown = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Projectile(rocket.x + 21, rocket.y, 10, 10));
		}
	}else {
		rocket.x = 250;
		rocket.y = 700;
	}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("testR");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.goRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.goLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.goUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.goDown = false;
		}
	}
}
