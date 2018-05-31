package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velx = (r.nextInt(5 - -5) + -5);
		vely = 5;
	}
	
	public Rectangle getBoudns() {
		return new Rectangle((int)x, (int)y,16,16);
	}
	

	public void tick() {
		x += velx;
		y +=vely;
		
		if(y>= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16,0.05f,handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}
	
	

	
}
