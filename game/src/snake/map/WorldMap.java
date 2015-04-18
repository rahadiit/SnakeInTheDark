package snake.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.core.SnakeStart;
import snake.interfacesAndAbstract.GameWorld;
import snake.levelSettings.WorldSettings;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: --------
 */

public class WorldMap extends GameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private BitmapFont font;
	private String congratz;
	private Texture texture;
	private Sprite sprite;
	
	public WorldMap (SnakeStart game /* Add other parameters of choice*/) {
		super(game);
		
		texture = new Texture(Gdx.files.internal("TorontoView.jpeg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setOrigin(0,0);
		sprite.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		//sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);

		
		/*font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		font.setColor(Color.GREEN);
		congratz = new String ("Well done, you pressed it!");*/
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		
		sprite.draw(batch);
		/*if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			font.draw(batch, "Now you're pressing the space button", 0, 80);
		font.draw(batch, congratz, 100 /*1280/2 - font.getBounds(congratz).width/2, 100/*720/2 - font.getBounds(congratz).height/2 );*/
	}
}
