package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	
	private float greenValue = 255;
	
	private int bounds =0;
	private int score=0;
	private int money;
	private int level=1;

	public void tick() {		
		HEALTH = Game.clamp(HEALTH, 0, 100 + (bounds/ 2)); 		/* because I multiplie HEALTH with 2 in row 44 */
		greenValue = HEALTH*2;
		greenValue = Game.clamp(greenValue, 0,255);
		
		score ++;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBounds() {
		return bounds;
	}

	public void setBounds(int bounds) {
		this.bounds = bounds;
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200 + bounds, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH *2 , 32);
		g.setColor(Color.black);
		g.drawRect(15, 15, 200 + bounds, 32);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		g.drawString("Space for shop", 15, 94);
	}
}
