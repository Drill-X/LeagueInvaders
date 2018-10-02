package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship player;
	boolean isAlive = true;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
	ArrayList<Projectile> projectileArray = new ArrayList<Projectile>();
	ArrayList<Alien> alienArray = new ArrayList<Alien>();

	public ObjectManager(Rocketship r) {
		player = r;
	}

	void draw(Graphics g) {
		player.draw(g);
		

		for (int i = 0; i < projectileArray.size() ; i++) {
			projectileArray.get(i).draw(g);
		}
		for (int i = 0; i < alienArray.size() ; i++) {
			alienArray.get(i).draw(g);
		}
	}

	void update() {
		player.update();
		for (int i = 0; i < projectileArray.size() ; i++) {
			projectileArray.get(i).update();
		}
		for (int i = 0; i < alienArray.size() ; i++) {
			alienArray.get(i).update();
		}
	}

	void addProjectile(Projectile p) {
		projectileArray.add(p);
	}
	void addAlien(Alien a) {
		alienArray.add(a);
	}
		public void manageEnemies(){
	        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	                addAlien(new Alien(new Random().nextInt(LeagueInvaders.Runner.WIDTH), 0, 50, 50));

	enemyTimer = System.currentTimeMillis();
	        }
}
void purgeObjects() {
	for (int i = 0; i < alienArray.size() ; i++) {
		if(alienArray.get(i).isAlive == false) {
			alienArray.remove(i);
		}	
	}
	for (int j = 0; j < projectileArray.size() ; j++) {
		if(projectileArray.get(j).isAlive == false) {
			projectileArray.remove(j);
		}}
}	

void checkCollision() {
	 for(Alien a : alienArray){
	        if(player.collisionBox.intersects(a.collisionBox)){
	        	player.isAlive = false;
	        }
	}
	 for (int i = 0; i < projectileArray.size(); i++) {
		 for (int j = 0; j < alienArray.size(); j++) {
		 if(projectileArray.get(i).collisionBox.intersects(alienArray.get(j).collisionBox)){
	        	projectileArray.get(i).isAlive = false;
	        	alienArray.get(j).isAlive = false;
	        	score++;
	        }
	}}
}

int getScore() {
	return score;
}
}