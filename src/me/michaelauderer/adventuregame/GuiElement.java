package me.michaelauderer.adventuregame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class GuiElement {
	
	public abstract void render(Graphics g);
	
	public abstract void update(int delta);
	
	public Image loadImage(String ref) {
		try {
			return new Image("resources/images/" + ref);
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}
}
