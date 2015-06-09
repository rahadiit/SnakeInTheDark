package snake.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.engine.creators.HUDSettings;
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

	private BitmapFont font;
	private String fontName = "fonts/ak_sc_o.fnt", hudName = "hud/hudFinal_compressed.png";
	private Texture tex;
	private Sprite sprite;
	
	public SnakeHUD (String levelData) {
		super();
		
		this.setBounds(0, 0, HUDSettings.getHudWidth(), HUDSettings.getHudHeight());
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		font = Loader.get(fontName);
		
		
		Loader.load(hudName, Texture.class);
		Loader.finishLoadingAsset(hudName);
		tex = Loader.get(hudName);
		
		sprite = new Sprite(tex);
	}
	
	
	public void show() {
		//TODO: Auto-generated method snub
	}
	
	
	@Override
	public void act (float delta) {
		super.act(delta);
		/*if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			System.out.println("Position: "+ WorldSettings.getVScreenX_Porc() + ":" + WorldSettings.getVScreenY_Porc());
			System.out.println("Size: "+ WorldSettings.getVScreenWidth_Porc() + ":" + WorldSettings.getVScreenHeight_Porc());
		}*/
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
		
		
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
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
