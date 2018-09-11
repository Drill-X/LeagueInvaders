package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
int speed;
boolean goUp = false;
boolean goDown = false;
boolean goLeft = false;
boolean goRight = false;
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}
	void update(){
		if(goUp == true) {
			setY(y - speed);
		}
		if(goDown == true) {
			setY(y + speed);
		}
		if(goLeft == true) {
			setX(x + speed);
		}
		if(goRight == true) {
			setX(x - speed);
		}
	}
	
	void draw(Graphics g) {
		   g.setColor(Color.BLUE);
		   g.fillRect(x, y, width, height);
	}
	
	void setX(int i) {
		x = i;
	}
	
	int getX() {
		return x;
	}
	
	void setY(int i) {
		y = i;
	}
	
	int getY() {
		return y;
	}
}
