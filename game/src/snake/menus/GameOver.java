package snake.menus;

import box2dLight.Light;
import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.visuals.Lights;
import snake.visuals.enhanced.VisualGameWorld;
import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;


/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> SnakeInTheDark Main Menu </br>
 * @author Mr.Strings
 */

public class GameOver extends VisualGameWorld {
	private BitmapFont font;
	private Sound gunFire, sensor;
	private Sprite title;
	private String fontName = "fonts/ak_sc_o.fnt";
	private String gameOver = "extras/GameOverScreen.png";
	private String gunFireName = "sounds/gunshot__shawnyboy__.wav";
	private String gunCockName = "sounds/gun-cock__smartwentcody__.wav";
	private String sensorPingName = "sounds/sensorPing_cutShorter.mp3";
	
	private Light illumination;
	
	private boolean transition = false;
	
	private float MIN_TRANSP = .3f, MAX_TRANSP = 1;
	;

	public GameOver() {
		
		WorldSettings.setWorldSize(1280, 720);
		WorldSettings.setCameraPosition(640, 360);
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		this.font = Loader.get(fontName);
		
		Loader.load(gameOver, Texture.class);
		Loader.finishLoadingAsset(gameOver);
		Texture tex = Loader.get(gameOver);
		title = new Sprite(tex);
		
		
		Loader.load(gunFireName, Sound.class);
		Loader.finishLoadingAsset(gunFireName);
		gunFire = Loader.get(gunFireName);
		
		Loader.load(sensorPingName, Sound.class);
		Loader.finishLoadingAsset(sensorPingName);
		sensor = Loader.get(sensorPingName);

		
		title.setBounds(157.5f,101, 965, 518);
		
	}

	@Override
	public void show() {
		WorldSettings.toggleVirtualScreen(false);
		WorldSettings.setAmbientColor(Color.BLACK);
		sensor.stop();
		sensor.loop(.2f, .9f, -1);
		gunFire.play();
		Gdx.input.setCursorCatched(false);
	}
	
	
	
	private float red = 1;
	private int distance = 2000;
	private float time = 0;
	
	/** updates Screen logic */
	@Override
	public void act(float delta) {
		if ((Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched() || time > 10) && !transition) {
			transition = true;
		}
		else if (transition) {
			
			if (red < 1) {
				WorldSettings.setAmbientColor(new Color(red, 1 - red, 0, 1));
				red+=.005f;
			}
			else if (red >= 1) {
				WorldSettings.setAmbientColor(Color.BLACK);
				illumination.setPosition(640, 0);
				illumination.setDistance(distance);
				illumination.setColor(Color.RED);
				distance-=20;
				Gdx.input.setCursorCatched(true);
				
				if (distance <= 0) {
						WorldSettings.setWorldSize(100, WorldSettings.heightFix(100));
						WorldSettings.toggleVirtualScreen(true);
						WorldSettings.setCameraPosition(50, WorldSettings.heightFix(50));
						sensor.stop();
						try {
							ScreenCreator.backToPrevious();
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}
		}
		
		time += delta;
	}
	
	
	/** Draws figures on Screen */
	@Override
	public void draw(Batch batch, float parentAlpha){
		title.draw(batch);
		
		if (Gdx.input.isKeyPressed(Input.Keys.H))
			font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, 700);
	}
	
	@Override
	public void createLights() {
		illumination = new PointLight (Lights.getRayhandler(), 5000, Color.YELLOW, 5000, 50, WorldSettings.heightFix(50));
	}
	
	
	

	@Override
	public void dispose() {
		illumination.remove();
		Loader.unload(fontName);
		Loader.unload(gameOver);
		Loader.unload(sensorPingName);
		Loader.unload(gunFireName);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}

