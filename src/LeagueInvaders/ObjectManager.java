package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
		Rocketship player;
	    boolean isAlive = true;
	    ArrayList<Projectile> projectileArray = new ArrayList<Projectile>();  
	    public ObjectManager (Rocketship r) {
	    player = r;
	    }
	    
	    void draw (Graphics g) {
	    	player.draw(g);
	    	for (int i = 0; i < projectileArray.size() - 1; i++) {
	    		projectileArray.get(i).update();	
			}
	    	
	    	for (int i = 0; i < projectileArray.size() - 1; i++) {
	    		projectileArray.get(i).draw(g);
			}
	    }
	    
	    void update() {
	    player.update();
	    }
	    
	    void addProjectile(Projectile p) {
	    	projectileArray.add(p);
	    }
}
