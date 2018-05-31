package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {

	private Handler handler;	

	private Color color;
	private Random r = new Random();

	private int dir = 0;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		
		dir = r.nextInt(2);
		if(dir == 0 ) {
			velx = 5;
			vely = 9;
		}else if(dir == 1) {
			velx = 9;
			vely = 5;
		}
		
		
		color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
	}

	public Rectangle getBoudns() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {
		x += velx;
		y += vely;

		if (y <= 0 || y >= Game.HEIGHT - 32)
			vely *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16)
			velx *= -1;

		handler.addObject(new Trail((int) x, (int) y, ID.Trail, color, 16, 16, 0.04f, handler));
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, 16, 16);
	}

}
