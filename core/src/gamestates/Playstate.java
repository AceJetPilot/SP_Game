package gamestates;

import managers.GameKeys;
import managers.GameStateManager;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import entities.Player;


public class Playstate extends GameState{
	
	private ShapeRenderer sr;
	
	private Player player;
	
	public Playstate(GameStateManager gsm){
		super(gsm);
	}

	public void init() {
		
		sr = new ShapeRenderer();
		
		player = new Player(); 
		
	}

	public void update(float dt) {
		System.out.println("play state updating");
		handleInput();
		
		player.update(dt);
	}

	public void draw() {
		System.out.println("play state drawing");
		player.draw(sr);
	}

	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		player.setDown(GameKeys.isDown(GameKeys.DOWN));
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
