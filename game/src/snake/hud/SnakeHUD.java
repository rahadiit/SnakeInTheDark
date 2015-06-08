package snake.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import snake.engine.creators.HUDSettings;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.engine.models.HUD;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * Game HUD, to display status and general information
 * 
 * @author Mr.Strings
 */


public class SnakeHUD extends HUD {
	private SnakeInfosHUD infos;
	private SnakeDialogHUD dialog;
	private BitmapFont font;
	private String fontName = "fonts/ak_sc_o.fnt";
	
	public SnakeHUD (String levelData) {
		super();
		
		infos = new SnakeInfosHUD();
		
		
		dialog  = new SnakeDialogHUD();
		dialog.setPosition(5, 5);
		//this.addActor(dialog);
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		this.font = Loader.get(fontName);
	}
	
	
	public void show() {
		//TODO: Auto-generated method snub
	}
	
	
	@Override
	public void act (float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			System.out.println("Position: "+ WorldSettings.getVScreenX_Porc() + ":" + WorldSettings.getVScreenY_Porc());
			System.out.println("Size: "+ WorldSettings.getVScreenWidth_Porc() + ":" + WorldSettings.getVScreenHeight_Porc());
		}
	}
	
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		// Draw fps
		font.setColor(Color.GREEN);
		
		if (Gdx.input.isKeyPressed(Input.Keys.H) || Gdx.input.isTouched())
			font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, this.getHeight());
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			font.setColor(Color.MAGENTA);
			font.draw(batch, "Wow. Just... Wow.", 50, 50);
		}
	}


	@Override
	public void dispose() {
		font.dispose();
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
}
