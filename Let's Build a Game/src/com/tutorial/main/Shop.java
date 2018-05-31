package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tutorial.main.Game.STATE;

public class Shop extends MouseAdapter{
	
	private Handler handler;
	private HUD hud;	
	
	private int B1 =100;
	private int B2=100;
	private int B3 =100;
	
	private boolean fullHealth = false;
	
	public Shop(Handler handler,HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g) {

		this.hud.setMoney(hud.getScore());
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0 , 48));
		g.drawString("SHOP", Game.WIDTH/2 -100, 50);
		
		//box 1
		g.setFont(new Font("arial", 0 , 12));
		g.drawString("Upgrate Health", 110, 120);
		g.drawString("Cost: " + B1, 110, 140);
		g.drawRect(100, 100, 100, 80);
		
		// box 2
		g.drawString("Upgrate Speed", 260, 120);
		g.drawString("Cost: " + B2, 260, 140);
		g.drawRect(250, 100, 100, 80);

		// box 3
		g.drawString("Refill Health", 410, 120);
		g.drawString("Cost: " + B3, 410, 140);
		g.drawRect(400, 100, 100, 80);
		
		g.drawString("Score" + hud.getScore(), Game.WIDTH/2 -50, 300);
		g.drawString("Press Space to go back", Game.WIDTH/2 -50, 330);

	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (Game.gameState == STATE.Shop) {
			// box 1
			if (mouseOver(mx, my, 100, 100, 100, 80)) {

				System.out.println(hud.getMoney());
				if (hud.getMoney() >= B1 && !fullHealth) {
					hud.setMoney(hud.getMoney() - B1);
					B1 = (int) (B1 * 1.1);
					hud.setBounds(hud.getBounds() + 15);
					System.out.println("aaa" + (hud.getBounds())+ "b" + (Game.WIDTH - 15));
					if ((hud.getBounds()+225) <= Game.WIDTH - 15) {
						
						HUD.HEALTH = (100 + (hud.getBounds() / 2));
					} else {
						fullHealth = true;
						hud.setBounds(hud.getBounds() - 15);
						HUD.HEALTH = (100+(hud.getBounds() / 2));
					}
				}
				else if(fullHealth){
					if (hud.getMoney() >= B3) {
						hud.setMoney(hud.getMoney() - B3);
						B3 = (int) (B3 * 1.05);
						HUD.HEALTH = (100 + (hud.getBounds() / 2));
					}
				}
			}

			// box 2
			if (mouseOver(mx, my, 250, 100, 100, 80)) {
				if (hud.getMoney() >= B2) {
					hud.setMoney(hud.getMoney() - B2);
					B2 = (int) (B2 * 1.1);
					handler.setSpeed(handler.getSpeed() + 1);
				}
			}

			// box 3
			if (mouseOver(mx, my, 400, 100, 100, 80)) {
				if (hud.getMoney() >= B3) {
					hud.setMoney(hud.getMoney() - B3);
					B3 = (int) (B3 * 1.05);
					HUD.HEALTH = (100 + (hud.getBounds() / 2));
				}
			}
		}
	}

	private boolean mouseOver(int mx,int my,int x,int y,int width,int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height ) {
				return true;
			}
		}		
		return false;		
	}
	
}
