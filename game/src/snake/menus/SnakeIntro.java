package snake.menus;

import box2dLight.Light;
import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import snake.visuals.Lights;
import snake.visuals.enhanced.VisualGameWorld;
import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import umbra.text.IComunicator;
import umbra.text.TextComunicator;


/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Intro for SnakeInTheDark demo levels </br>
 * @author Mr.Strings
 */

public class SnakeIntro extends VisualGameWorld {
	private BitmapFont font;
	private Music song;
	private IComunicator textMan;
	private Sound missile, explosion;
	
	private String fontName = "fonts/ak_sc_o.fnt",
				   missileName = "sounds/missile.mp3",
				   explosionName = "sounds/explosionIntro.mp3",
				   musicName = "music/erh__atmosphere-4.mp3";
	
	private Light illumination;
	
	private boolean transition = false;

	public SnakeIntro() {
		
		WorldSettings.setWorldSize(1280, 720);
		WorldSettings.setCameraPosition(640, 360);
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		this.font = Loader.get(fontName);
		this.font.getData().setScale(.5f);
		
		Loader.load(missileName, Sound.class);
		Loader.finishLoadingAsset(missileName);
		missile = Loader.get(missileName);
		
		Loader.load(explosionName, Sound.class);
		Loader.finishLoadingAsset(explosionName);
		explosion = Loader.get(explosionName);
		
		Loader.load(musicName, Music.class);
		Loader.finishLoadingAsset(musicName);
		song = Loader.get(musicName);
		
		textMan = new TextComunicator(ScreenCreator.getBatch(), font);
		
		textMan.newText("Radio message intercepted August 23rd, 22:35: ",
						390, 400, 500, true);
	}

	@Override
	public void show() {
		WorldSettings.toggleVirtualScreen(false);
		WorldSettings.setAmbientColor(Color.WHITE);
		song.setVolume(.2f);
		song.play();
	}
	
	
	
	private float red = 1;
	private int distance = 2000;
	private float time = 0;
	private boolean got1 = false, got2 = false, got3 = false,
					got4 = false, got5 = false, got6 = false,
					got7 = false, got8 = false, got9 = false,
					got10 = false, got11 = false, got12 = false, got13 = false;
	private float FINISH_TIME1 = 4, FINISH_TIME2 = 8, FINISH_TIME3 = 9,
				  FINISH_TIME4 = 12, FINISH_TIME5 = 19, FINISH_TIME6 = 20,
				  FINISH_TIME7 = 22, FINISH_TIME8 = 22.5f, FINISH_TIME9 = 23.5f,
				  FINISH_TIME10 = 26, FINISH_TIME11 = 30, FINISH_TIME12 = 35, FINISH_TIME13 = 37;
	private float FINISH_TIME  = 41;
	
	/** updates Screen logic */
	@Override
	public void act(float delta) {
		
		textMan.update(delta);
		
		if (!got1 && time > FINISH_TIME1) {
			textMan.newText("\"Millions of people... all those dreams on fire...\"",
					390, 400, 500, true);
			got1 = true;
		}
		
		if (!got2 && time > FINISH_TIME2) {
			textMan.newText("Origin:", 390, 400, 500, true);
		got2 = true;
		}
		
		if (!got3 && time > FINISH_TIME3) {
			textMan.newText("Extinct vulcano in the Atlantic.", 390, 400, 500, true);
		got3 = true;
		}
		
		if (!got4 && time > FINISH_TIME4) {
			textMan.newText("Former operation unit of terrorist organization Tyrannus, held responsable for the launch of A.N.T.A (Aereal Non-Tripulated Armaggedon) in 1963.",
					390, 400, 500, true);
			got4 = true;
		}
		
		if (!got5 && time > FINISH_TIME5) {
			textMan.newText("Your task:",
					390, 400, 500, true);
			got5 = true;
		}
		
		if (!got6 && time > FINISH_TIME6) {
			textMan.newText("Find out the source of the signal. Go by jet.",
					390, 400, 500, true);
			got6 = true;
		}
		
		if (!got7 && time > FINISH_TIME7) {
			textMan.newText("Almost th",
					390, 400, 500, true);
			got7 = true;
		}
		
		if (!got8 && time > FINISH_TIME8) {
			song.stop();
			missile.play();
			got8 = true;
		}
		
		if (!got9 && time > FINISH_TIME9) {
			textMan.newText("",
					390, 400, 500, true);
			explosion.play();
			got9 = true;
		}
		
		if (!got10 && time > FINISH_TIME10) {
			textMan.newText("Plane explosion, boss. Soldier, are you there?",
					390, 400, 500, true);
			got10 = true;
		}
		
		if (!got11 && time > FINISH_TIME11) {
			song.play();
			textMan.newText("Good... well, almost. Your activity sensor is on, but night-vision googles are destroyed.",
					390, 400, 500, true);
			got11 = true;
		}
		
		if (!got12 && time > FINISH_TIME12) {
			textMan.newText("And there is no way out but...",
					390, 400, 500, true);
			got12 = true;
		}
		
		if (!got13 && time > FINISH_TIME13) {
			textMan.newText("down.",
					390, 400, 500, true);
			got13 = true;
		}
		
		
		if ((time > FINISH_TIME || (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched())) && !transition)
			transition = true;
		else if (transition) {
			if (red < 1) {
				WorldSettings.setAmbientColor(new Color(red, 1 - red, 0, 1));
				red+=.005f;
			}
			else if (red >= 1) {
				WorldSettings.setAmbientColor(Color.BLACK);
				illumination.setPosition(640, 0);
				illumination.setDistance(distance);
				illumination.setColor(Color.DARK_GRAY);
				distance-=20;
				
				if (distance <= 0) {
						WorldSettings.setWorldSize(100, WorldSettings.heightFix(100));
						WorldSettings.toggleVirtualScreen(true);
						WorldSettings.setCameraPosition(50, WorldSettings.heightFix(50));
						song.stop();
						try {
							ScreenCreator.switchAndGo("SnakeScreen", "TiledMap", "maps/level1.tmx");
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}
		}
		
		time += delta;
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
			Gdx.app.exit();
	}
	
	
	/** Draws figures on Screen */
	@Override
	public void draw(Batch batch, float parentAlpha){
		batch.end();
		textMan.draw();
		batch.begin();
		
		if (Gdx.input.isKeyPressed(Input.Keys.H))
			font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, 700);
	}
	
	@Override
	public void createLights() {
		illumination = new PointLight (Lights.getRayhandler(), 5000, Color.WHITE, 5000, 50, WorldSettings.heightFix(50));
	}
	
	
	

	@Override
	public void dispose() {
		illumination.remove();
		Loader.unload(fontName);
		Loader.unload(missileName);
		Loader.unload(explosionName);
		Loader.unload(musicName);
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

