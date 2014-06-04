package me.michaelauderer.adventuregame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;

public class FillBar extends GuiElement {

	private Image empty;
	private Color color;
	private String title;
	private boolean showNumbers;
	private TrueTypeFont font;
	private float x, y;
	
	public int max, value;
	
	public FillBar(Image empty, Color color, float x, float y, int max, int initial, String title, boolean showNumbers, TrueTypeFont font) {
		this.empty = empty;
		this.color = color;
		this.x = x;
		this.y = y;
		this.max = max;
		this.value = initial;
		this.title = title;
		this.showNumbers = showNumbers;
		this.font = font;
	}
	
	public FillBar(Image empty, Color color, float x, float y, int max, int initial) {
		this(empty, color, x, y, max, initial, " ", false, null);
	}
	
	@Override
	public void render(Graphics g) {
		empty.draw(x, y);
		float percentage = (float) value / (float) max;
		g.setColor(color);
		g.fillRect(x + 2, y + 2, clip(empty.getWidth() * percentage - 4, 0), empty.getHeight() - 4);
		
		if (showNumbers) {
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString(title, x + 4, y);
			g.drawString(value + "/" + max, x + empty.getWidth() / 2 - font.getWidth(value + "/" + max) / 2,
					y + empty.getHeight() / 2 - font.getHeight() / 2);
		}
	}
	
	private float clip(float i, int clip) {
		if (i > clip) {
			return i;
		} else {
			return clip;
		}
	}

	@Override
	public void update(int delta) {

	}
}
