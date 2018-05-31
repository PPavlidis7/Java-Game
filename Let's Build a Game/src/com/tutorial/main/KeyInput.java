package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;  // W
		keyDown[1] = false;  // S 
		keyDown[2] = false;	 // D
		keyDown[3] = false;  // A 
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
				
		for(int i=0; i< handler.object.size() ; i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				// key event for player 1
				
				if(key == KeyEvent.VK_W) { tempObject.setVely(-handler.getSpeed()); keyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVely(handler.getSpeed()); keyDown[1] = true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelx(handler.getSpeed()); keyDown[2] = true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelx(-handler.getSpeed()); keyDown[3] = true; }
			}
		}
		if (key == KeyEvent.VK_P) {
			
			if(Game.gameState == STATE.Game) {
			if (Game.paused)
				Game.paused = false;
			else
				Game.paused = true;
			}
		}
		if( key == KeyEvent.VK_ESCAPE) System.exit(1);
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game) {
				Game.gameState = STATE.Shop;
			}else if(Game.gameState == STATE.Shop)
				Game.gameState = STATE.Game;
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key= e.getKeyCode();
		
		for(int i=0; i< handler.object.size() ; i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				// key event for player 1
				
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				if(key == KeyEvent.VK_D) keyDown[2] = false;
				if(key == KeyEvent.VK_A) keyDown[3] = false;
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setVely(0);
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelx(0);
			}
		}
	}

}
