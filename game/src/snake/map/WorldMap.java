package snake.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import snake.core.SnakeStart;
import snake.interfacesAndAbstract.GameWorld;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: --------
 */

public class WorldMap extends GameWorld {
	
	// The code below is simply a prototype for testing purposes 
	BitmapFont font;
	String congratz;
	
	public WorldMap (SnakeStart game /* Add other parameters of choice*/) {
		super(game);
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		font.setColor(Color.GREEN);
		congratz = new String ("Well done, you pressed it!");
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			font.draw(batch, "Now you're pressing the space button", 0, 80);
		font.draw(batch, congratz, 100 /*1280/2 - font.getBounds(congratz).width/2*/, 100/*720/2 - font.getBounds(congratz).height/2*/ );
	}
}
