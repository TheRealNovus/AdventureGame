package me.michaelauderer.adventuregame;

import org.newdawn.slick.Graphics;

public class GuiManager {
	
	AdventureGame game;
	Screen currentScreen;

	public GuiManager(AdventureGame game) {
		this.game = game;
		currentScreen = new GameScreen(game);
	}
	
	public void render(Graphics g) {
		currentScreen.render(g);
	}

	public void update(int delta) {
		currentScreen.update(delta);
	}
}
