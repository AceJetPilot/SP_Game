package com.Scroller.game;

import managers.GameInputProcessor;
import managers.GameKeys;
import managers.GameStateManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class Game implements ApplicationListener {
	
	public static Vector2 SIZE, CENTER;
	
	public static int WIDTH;
	public static int HEIGHT;

	public static OrthographicCamera cam;
	
	private GameStateManager gsm;
	
	public float time;
	public int frames, fps;
	
	public void create(){
		
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		int width, height;
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		SIZE = new Vector2(width, height);
		CENTER = new Vector2(width * .5f, height * .5f);
		
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH / 2, HEIGHT / 2);
		cam.update();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());
		
		gsm = new GameStateManager();
	}
	
	public void render(){
		
		// clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		
		GameKeys.update();
		
		float dt = Gdx.graphics.getDeltaTime();
		frames++;
		time += dt;
		if(time >= 1){
			fps = frames;
			frames = 0;
			time = 0;
		}
		
		Gdx.graphics.setTitle("Scroller | " + fps + " fps");
		
	}
	
	public void resize(int width, int height) {}
	public void pause() {}
	public void resume() {}
	public void dispose() {}

}
