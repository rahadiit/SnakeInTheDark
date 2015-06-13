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
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.visuals.Lights;
import snake.visuals.enhanced.VisualGameWorld;
import snake.visuals.enhanced.VisualWorldStage;
import com.badlogic.gdx.scenes.scene2d.Stage;
import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.engine.models.HUD;


/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Example menu for SnakeEngine </br>
 * @author Mr.Strings
 */

public class SnakeHub extends VisualGameWorld {
	private BitmapFont font;
	private Sound gunFire;
	private Sprite title;
	private float w, h;
	private String instructions[]; //will be changed to buttons
	private String fontName = "fonts/ak_sc_o.fnt";
	private String titleScreen = "extras/titleScreen_white.png";
	private String crosshair_cursor = "extras/crosshair_blue.png";
	private String gunFireName = "sounds/gunshot__shawnyboy__.wav";
	
	private Light illumination;
	
	private boolean transition = false;
	
	private float MIN_TRANSP = .3f, MAX_TRANSP = 1;
	;

	public SnakeHub() {
		
		WorldSettings.setWorldSize(1280, 720);
		WorldSettings.setCameraPosition(640, 360);
		
		Loader.load(crosshair_cursor, Pixmap.class);
		Loader.finishLoadingAsset(crosshair_cursor);
		Pixmap cursor = Loader.get(crosshair_cursor);
		Gdx.input.setCursorImage(cursor, cursor.getWidth()/2, cursor.getHeight()/2);
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		this.font = Loader.get(fontName);
		
		Loader.load(titleScreen, Texture.class);
		Loader.finishLoadingAsset(titleScreen);
		Texture tex = Loader.get(titleScreen);
		title = new Sprite(tex);
		
		
		Loader.load(gunFireName, Sound.class);
		Loader.finishLoadingAsset(gunFireName);
		gunFire = Loader.get(gunFireName);

		w = 100;
		h = 100;
		
		title.setBounds(157.5f,101, 965, 518);
		
		instructions = new String[3];
	}

	@Override
	public void show() {
		WorldSettings.toggleVirtualScreen(false);
		WorldSettings.setAmbientColor(Color.GREEN);
	}
	
	
	
	private float red = 1;
	private int distance = 2000;
	
	/** updates Screen logic */
	@Override
	public void act(float delta) {
		if ((Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) && !transition) {
			gunFire.play();
			transition = true;
		}
		
		else if (transition) {
			
			if (red < 1) {
				WorldSettings.setAmbientColor(new Color(red, 1 - red, 0, 1));
				red+=.02f;
			}
			else if (red >= 1) {
				WorldSettings.setAmbientColor(Color.BLACK);
				illumination.setPosition(640, 0);
				illumination.setDistance(distance);
				illumination.setColor(Color.RED);
				distance-=20;
				
				if (distance <= 0) {
						WorldSettings.setWorldSize(100, WorldSettings.heightFix(100));
						WorldSettings.toggleVirtualScreen(true);
						try {
							ScreenCreator.switchAndGo("SnakeScreen", "TiledMap", "maps/level1.tmx");
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}
		}
		
		//Camera Movement
			if (Gdx.input.isKeyPressed(Input.Keys.A))
				getStage().getCameraMan().moveCamera(-20f * delta, 0);
					
			if (Gdx.input.isKeyPressed(Input.Keys.D))
				getStage().getCameraMan().moveCamera(20f * delta, 0);
					
			if (Gdx.input.isKeyPressed(Input.Keys.S))
				getStage().getCameraMan().moveCamera( 0, -20f * delta);
					
			if (Gdx.input.isKeyPressed(Input.Keys.W))
				getStage().getCameraMan().moveCamera(0, 20f * delta);
					
			//Camera Zoom
			if (Gdx.input.isKeyPressed(Input.Keys.O))
				getStage().getCameraMan().zoomCamera(-.5f * delta);
				
			if (Gdx.input.isKeyPressed(Input.Keys.P))
				getStage().getCameraMan().zoomCamera(.5f * delta);
				
				
			//Virtual Camera Movement
			if (Gdx.input.isKeyPressed(Input.Keys.L))
				getStage().getCameraMan().moveVCamera(.01f, 0);
				
			if (Gdx.input.isKeyPressed(Input.Keys.J))
				getStage().getCameraMan().moveVCamera(-.01f, 0);
					
			if (Gdx.input.isKeyPressed(Input.Keys.I))
				getStage().getCameraMan().moveVCamera(0, .01f);
				
			if (Gdx.input.isKeyPressed(Input.Keys.K))
				getStage().getCameraMan().moveVCamera(0, -.01f);
					
			//Virtual Camera Zoom
			if (Gdx.input.isKeyPressed(Input.Keys.U))
				getStage().getCameraMan().zoomVCamera(.01f);
					
			if (Gdx.input.isKeyPressed(Input.Keys.Y))
				getStage().getCameraMan().zoomVCamera(-.01f);
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
		illumination = new PointLight (Lights.getRayhandler(), 5000, new Color(1f, 1f, 1f, 1f), 5000, 50, WorldSettings.heightFix(50));
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
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}

