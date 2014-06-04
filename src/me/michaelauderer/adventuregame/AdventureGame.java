package me.michaelauderer.adventuregame;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import de.matthiasmann.twl.GUI;
import de.matthiasmann.twl.ToggleButton;
import de.matthiasmann.twl.Widget;
import de.matthiasmann.twl.renderer.lwjgl.LWJGLRenderer;
import de.matthiasmann.twl.theme.ThemeManager;

public class AdventureGame implements Game {
	
	public static final String TITLE = "Adventure Game";
	public static final int WIDTH = 900;
	public static final int HEIGHT = 680;
	public static final int TILE_SIZE = 20;
	
	public Player player;
	public GuiManager gui;
	public Font rawFont;

	public static void main(String[] args) {
		AdventureGame game = new AdventureGame();
		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(WIDTH, HEIGHT, false);
			container.setShowFPS(false);
			container.setClearEachFrame(true);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setBackground(Color.black);
		gui.render(g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		rawFont = new Font("Corbel", Font.PLAIN, 18);
		player = new Player(this);
		gui = new GuiManager(this);
		
		gc.getInput().addKeyListener(player);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.update(delta);
		gui.update(delta);
	}

	@Override
	public boolean closeRequested() {
		return true;
	}

	@Override
	public String getTitle() {
		return TITLE;
	}

	public TrueTypeFont getFont(float size) {
		return new TrueTypeFont(rawFont.deriveFont(size), true);
	}
}
