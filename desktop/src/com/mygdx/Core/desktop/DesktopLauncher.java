package com.mygdx.Core.desktop;

import snake.core.SnakeStart;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "SnakeInTheDark";
		config.width = 1280;
	    config.height = 720;
		new LwjglApplication(new SnakeStart(), config);
	}
}
