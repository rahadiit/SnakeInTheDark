package snake.menus;

import box2dLight.Light;
import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
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

public class SnakeHub extends VisualGameWorld {
	private BitmapFont font;
	private Sound gunCock, gunFire;
	private Music introAudio;
	private Sprite title;
	private String fontName = "fonts/ak_sc_o.fnt";
	private String titleScreen = "extras/titleScreen_white.png";
	private String crosshair_cursor = "extras/crosshair_blue.png";
	private String gunFireName = "sounds/gunshot__shawnyboy__.wav";
	private String gunCockName = "sounds/gun-cock__smartwentcody__.wav";
	private String introName = "music/SnakeInTheDarkIntro_v2.wav";
	
	private Light illumination;
	
	private boolean transition = false;

	public SnakeHub() {
		
		WorldSettings.setWorldSize(1280, 720);
		WorldSettings.setCameraPosition(640, 360);
		
		Loader.load(crosshair_cursor, Pixmap.class);
		Loader.finishLoadingAsset(crosshair_cursor);
		Pixmap cursor = Loader.get(crosshair_cursor);
		Gdx.input.setCursorImage(cursor, cursor.getWidth()/2, cursor.getHeight()/2);
		Gdx.input.setCursorCatched(true);
		
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
		
		Loader.load(gunCockName, Sound.class);
		Loader.finishLoadingAsset(gunCockName);
		gunCock= Loader.get(gunCockName);
		
		Loader.load(introName, Music.class);
		Loader.finishLoadingAsset(introName);
		introAudio = Loader.get(introName);
		
		title.setBounds(157.5f,101, 965, 518);
		
	}

	@Override
	public void show() {
		WorldSettings.toggleVirtualScreen(false);
		WorldSettings.setAmbientColor(Color.BLACK);
	}
	
	
	
	private float red = 1;
	private int distance = 2000;
	private float time = 0;
	private String text = "";
	
	private float MIN_POSITION = -1000, MAX_POSITION = 1280;
	private float lightSpeed = .2f;
	
	private boolean got0 = false, got1 = false, got2 = false, got3 = false;
private float FINISH_TIME1 = 7, FINISH_TIME2 = 15, FINISH_TIME3 = 23;
	
	private static float FINISH_TIME = 31.3f;
	private static boolean got = false;
	private static boolean playingLast = false;
	private static boolean started = false;
	
	/** updates Screen logic */
	@Override
	public void act(float delta) {

		if (started) {
			if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) && !transition) {
				gunFire.play();
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
					distance-=10;
					if (!playingLast) {
						introAudio.play();
						playingLast = true;
					}
					
					if (distance <= 0) {
							WorldSettings.setWorldSize(100, WorldSettings.heightFix(100));
							WorldSettings.toggleVirtualScreen(true);
							WorldSettings.setCameraPosition(50, WorldSettings.heightFix(50));
							introAudio.stop();
							try {
								ScreenCreator.switchAndGo("SnakeScreen", "SnakeIntro", "");
							} catch (Exception e) {
								e.printStackTrace();
							}
					}
				}
			}
			
			
			if (time < FINISH_TIME1) {
				illumination.setPosition((float) ((MAX_POSITION - MIN_POSITION) * Math.abs(Math.sin(lightSpeed * time)) + MIN_POSITION), WorldSettings.heightFix(250));
			}
			
			//Credits
			
			if (!got0) {
				introAudio.play();
				illumination.setColor(new Color(0, 1f, 1f, 1f));
				illumination.setDistance(900);
				text = "Engine and lights:\n Mr.Strings\nJessica Oliveira";
				got0 = true;
			}
			
			if (time > FINISH_TIME1 && time < FINISH_TIME3) {
				illumination.setPosition(500, (float) ((MAX_POSITION - MIN_POSITION) * Math.abs(Math.sin(lightSpeed * time)) + MIN_POSITION));
			}
			
			if (time > FINISH_TIME1 && !got1) {
				illumination.setColor(new Color(.3f, 0f, 1f, 1f));
				illumination.setDistance(1000);
				text = "Maps:\n Gabriel Souza\n Franco";
				got1 = true;
			}
		
			if (time > FINISH_TIME2 && !got2) {
				illumination.setColor(new Color(1f, .4f, 1f, 1f));
				text = "Player and Enemies:\n Agustina e\n Guilherme";
				got2 = true;
			}
			
			if (time > FINISH_TIME3 && time < FINISH_TIME) {
				illumination.setPosition((float) ((MAX_POSITION - MIN_POSITION) * Math.abs(Math.sin(lightSpeed * time)) + MIN_POSITION), WorldSettings.heightFix(250));
			}
			if (time > FINISH_TIME3 && !got3) {
				illumination.setColor(new Color(1f, 1f, 0f, 1f));
				text = "Equipments:\n Beatriz e\n Gabriel Gimenez";
				got3 = true;
			}
			
			
			time += delta;
			
			if (time >= FINISH_TIME && !got) {
				Gdx.input.setCursorCatched(false);
				introAudio.pause();
				gunCock.play();
				got = true;
				WorldSettings.setAmbientColor(Color.GREEN);
				illumination.setColor(Color.WHITE);
				illumination.setPosition(50, WorldSettings.heightFix(50));
				illumination.setDistance(5000);
			}
			
			if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
				Gdx.app.exit();
		}
		
		else {
			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) {
				started = true;
				//illumination.setDistance();
			}
		}
	}
	
	
	/** Draws figures on Screen */
	@Override
	public void draw(Batch batch, float parentAlpha){
		if (started) {
			if (font == null)
				System.out.println("AUUAA");
			
			if (time < FINISH_TIME)
				font.draw(batch, text, 400, 500);
				
		
			
			if (time > FINISH_TIME) {
				title.draw(batch);
			}
			
			if (Gdx.input.isKeyPressed(Input.Keys.H))
				font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, 700);
		}
		else {
			font.draw(batch, "A\n No Dark Glasses\n Production", 400, 500);
			font.draw(batch, "Please", 950, 200);
			font.draw(batch, "turn off the lights.", 700, 150);
		}
	}
	
	@Override
	public void createLights() {
		illumination = new PointLight (Lights.getRayhandler(), 5000, Color.WHITE, 1500, 500, WorldSettings.heightFix(250));
	}
	
	
	

	@Override
	public void dispose() {
		illumination.remove();
		Loader.unload(fontName);
		Loader.unload(crosshair_cursor);
		Loader.unload(titleScreen);
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

