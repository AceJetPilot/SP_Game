package com.Scroller.game.desktop;

import com.Scroller.game.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args){
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Scroller";
		cfg.width = 500;
		cfg.height = 400;
		cfg.resizable = false;
		//cfg.useGL30 = false;
		
		new LwjglApplication(new Game(), cfg);
	}

}
