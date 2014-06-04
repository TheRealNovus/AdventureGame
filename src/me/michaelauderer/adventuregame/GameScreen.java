package me.michaelauderer.adventuregame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GameScreen extends Screen {
	
	private AdventureGame game;
	
	private Image hud_bg, hud_portrait, hud_level, hud_inventory, hud_quests, hud_map;
	
	private Button inventoryButton, questsButton, mapButton;
	
	private FillBar experienceBar, healthBar, energyBar;
	
	private TiledMap map;
	
	private int cameraX, cameraY;
	
	public GameScreen(AdventureGame game) {
		this.game = game;
		
		hud_bg = loadImage("gui/hud_bg.png");
		hud_portrait = loadImage("gui/hud_portrait.png");
		hud_level = loadImage("gui/hud_level.png");
		hud_inventory = loadImage("gui/hud_inventory.png");
		hud_quests = loadImage("gui/hud_quests.png");
		hud_map = loadImage("gui/hud_map.png");
		
		inventoryButton = new Button(697, 23, hud_inventory);
		questsButton = new Button(748, 23, hud_quests);
		mapButton = new Button(799, 23, hud_map);
		
		experienceBar = new FillBar(loadImage("gui/hud_experience_empty.png"), new Color(144, 92, 166), 
				27, 120, game.player.maxHealth, game.player.health);
		healthBar = new FillBar(loadImage("gui/hud_health.png"), new Color(240, 72, 51), 161, 18, 100, 100, 
				"health", true, game.getFont(18));
		energyBar = new FillBar(loadImage("gui/hud_health.png"), new Color(207, 144, 35), 430, 18, 100, 100, 
				"energy", true, game.getFont(18));
		
		try {
			map = new TiledMap("resources/tilesets/grass.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		cameraX = game.player.x - AdventureGame.WIDTH / 2;
		cameraY = game.player.y - AdventureGame.HEIGHT / 2;
	}
	
	@Override
	public void update(int delta) {
		cameraX = game.player.x - AdventureGame.WIDTH / 2;
		cameraY = game.player.y - AdventureGame.HEIGHT / 2;
		experienceBar.value = game.player.experience;
		healthBar.value = game.player.health;
		healthBar.max = game.player.maxHealth;
		energyBar.value = game.player.energy;
		energyBar.max = game.player.maxEnergy;
	}
	
	@Override
	public void render(Graphics g) {
		map.render(cameraX, cameraY);
		game.player.render(g);
		
		hud_bg.draw(0, 0);
		hud_portrait.draw(18, 18);
		hud_level.draw(101, 10);
		
		inventoryButton.render(g);
		questsButton.render(g);
		mapButton.render(g);
		
		g.setColor(new Color(144, 92, 166));
		g.setFont(game.getFont(28));
		String level = "" + game.player.level;
		g.drawString(level, 101 + (hud_level.getWidth() / 2) - (game.getFont(28).getWidth(level) / 2), 
				10 + (hud_level.getHeight() / 2) - (game.getFont(28).getHeight(level) / 2));
		
		experienceBar.render(g);
		healthBar.render(g);
		energyBar.render(g);
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		inventoryButton.mouseClick();
		questsButton.mouseClick();
		mapButton.mouseClick();
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
	}

	@Override
	public void mousePressed(int button, int x, int y) {
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
	}

	@Override
	public void mouseWheelMoved(int change) {
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
	}
}
