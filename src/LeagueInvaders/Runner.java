package LeagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Runner {
	JFrame frame;
	final int WIDTH = 500;
	final int HIEGHT = 800;
	static GamePanel gamepanel;

	public Runner() {
		frame = new JFrame();
	}

	public static void main(String[] args) {
		Runner run = new Runner();
		gamepanel = new GamePanel();
		run.setup();
	}

	void setup() {
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setSize(WIDTH, WIDTH);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HIEGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamepanel.startGame();
	}
}
