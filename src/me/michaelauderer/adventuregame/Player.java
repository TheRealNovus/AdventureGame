package me.michaelauderer.adventuregame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

public class Player implements KeyListener {
	
	private AdventureGame game;
	
	public int health, maxHealth;
	public int energy, maxEnergy;
	public int experience, level;
	public int x, y;
	public int speed = 1;
	
	private Image playerImage;
	
	public Player(AdventureGame game) {
		this.game = game;
		
		health = 100;
		maxHealth = 100;
		energy = 100;
		maxEnergy = 100;
		experience = 0;
		level = 1;
		x = AdventureGame.HEIGHT / 2;
		y = AdventureGame.WIDTH / 2;
		
		try {
			playerImage = new Image("resources/images/sprites/player.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void addExperience(int exp) {
		experience += exp;
		while (experience >= 100) {
			levelUp();
			experience -= 100;
		}
	}
	
	public void update(int delta) {
		while (experience >= 100) {
			levelUp();
			experience -= 100;
		}
		
		if (health <= 0) {
			// die
		}
		
		if (health > maxHealth) {
			health = maxHealth;
		}
		
		if (energy > maxEnergy) {
			energy = maxEnergy;
		}
		
		
	}
	
	private void levelUp() {
		level++;
	}
	
	public void render(Graphics g) {
		g.drawImage(playerImage, x, y);
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input input) {
		input.addKeyListener(this);
	}

	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_UP:
			y+=speed;
			break;
		case Input.KEY_DOWN:
			y-=speed;
			break;
		case Input.KEY_RIGHT:
			x-=speed;
			break;
		case Input.KEY_LEFT:
			x+=speed;
			break;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
	}
}
