package LeagueInvaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
	}

void updateMenueState() {
		
	}
	
	void updateGameState() {
		
	}
	
	void updateEndstate()  {
		
	}
	
	void drawMenueState() {
		
	}
	
	void drawGameState() {
		
	}
	
	void drawEndState() {
		
	}
	@Override
	public void paintComponent(Graphics g) {
		//g.fillRect(10, 10, 100, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("test");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("testT");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("testP");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("testR");
	}
}
