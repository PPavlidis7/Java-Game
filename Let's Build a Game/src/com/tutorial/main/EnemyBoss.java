package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	private int timer =80;
	private int timer2 =50;
	
	public EnemyBoss(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velx = 0;
		vely = 2;
	}
	
	public Rectangle getBoudns() {
		return new Rectangle((int)x, (int)y,96,96);
	}
	

	public void tick() {
		x += velx;
		y +=vely;
		
		if (timer <=0 ) vely =0;
		else timer --;
		
		if(timer <=0) timer2 --;
		if(timer2 <=0) {
			
			if(velx == 0  ) velx=5;
			if(velx > 0  ) velx += 0.005f;
			else if(velx <= 0  ) velx -= 0.005f;
			
			velx = Game.clamp(velx, -10, 10);
			
			int spam = r.nextInt(10);
			if(spam == 0) handler.addObject(new EnemyBossBullet((int)x+48,(int) y, ID.BasicEnemy, handler));
		}
		
		if(x <= 0 || x>= Game.WIDTH - 96) velx *= -1;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 96, 96);
	}
}
