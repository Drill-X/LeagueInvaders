package LeagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Runner {
	JFrame frame;
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
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
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gamepanel.startGame();
	}
}
