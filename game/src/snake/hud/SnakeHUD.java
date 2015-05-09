package snake.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import snake.engine.GameWorld;
import snake.engine.HUD;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * Game HUD, to display status and general information
 * 
 * @author Mr.Strings
 */


public class SnakeHUD extends HUD {
	GameWorld world;
	SnakeInfosHUD infos;
	SnakeDialogHUD dialog;
	BitmapFont font;
	
	public SnakeHUD (GameWorld world) {
		super(world);
		this.world = world;
		
		infos = new SnakeInfosHUD(world);
		dialog  = new SnakeDialogHUD(world);
		
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
	}
	
	
	public void draw(Batch batch, float parentAlpha) {
		// Draw fps
		font.setColor(Color.GREEN);
		
		font.getData().setScale(1f);
		font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, this.getHeight());
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			font.setColor(Color.MAGENTA);
			font.draw(batch, "Wow. Just... Wow.", 50, 50);
		}
		
		font.setColor(Color.ORANGE);
		font.getData().setScale(.5f);
		font.draw(batch, "Use Directional Arrows and IJKL for moving, YU and OP for zooming", this.getWidth()/4, this.getHeight() * 99/100);
		//Ends drawing
	}


	@Override
	public void dispose() {
		font.dispose();
	}
}
