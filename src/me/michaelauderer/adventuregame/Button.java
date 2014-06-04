package me.michaelauderer.adventuregame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Button extends GuiElement {
	
	private float x, y;
	private int width, height;
	private Image image;
	private Color color;
	private String text;
	
	public Button(float x, float y, Image image) {
		this(x, y, image, Color.white, "");
	}
	
	public Button(float x, float y, Image image, Color color, String text) {
		this(x, y, image.getWidth(), image.getHeight(), image, color, text);
	}
	
	public Button(float x, float y, int width, int height, Image image, Color color, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.color = color;
		this.text = text;
	}
	
	public void mouseClick() {
		
	}

	@Override
	public void render(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y);
		}
	}

	@Override
	public void update(int delta) {
	}
	
	
}
