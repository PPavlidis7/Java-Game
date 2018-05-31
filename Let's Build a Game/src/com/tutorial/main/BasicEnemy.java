package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velx = 5;
		vely = 5;
	}
	
	public Rectangle getBoudns() {
		return new Rectangle((int)x, (int)y,16,16);
	}
	

	public void tick() {
		x += velx;
		y +=vely;
		
		if(y <= 0 || y>= Game.HEIGHT - 32) vely *= -1;
		if(x <= 0 || x>= Game.WIDTH - 16) velx *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16,0.05f,handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}
	
	

	
}
