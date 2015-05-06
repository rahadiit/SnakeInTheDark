package com.mygdx.Core.desktop;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */


import snake.core.SnakeStart;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "SnakeInTheDark";
		config.width = 1920;
	    config.height = 1080;
		new LwjglApplication(new SnakeStart(), config);
	}
}
