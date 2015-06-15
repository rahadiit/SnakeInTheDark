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
import umbra.text.IComunicator;
import umbra.text.TextComunicator;


/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Example menu for SnakeEngine </br>
 * @author Mr.Strings
 */

public class SnakeIntro extends VisualGameWorld {
	private BitmapFont font;
	private String fontName = "fonts/ak_sc_o.fnt";
	private IComunicator textMan;
	
	private Light illumination;
	
	private boolean transition = false;

	public SnakeIntro() {
		
		WorldSettings.setWorldSize(1280, 720);
		WorldSettings.setCameraPosition(640, 360);
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		this.font = Loader.get(fontName);
		this.font.getData().setScale(.5f);
		
		textMan = new TextComunicator(ScreenCreator.getBatch(), font);
		
		textMan.newText("Mensagem interceptada dia 23 de agosto, 22:35. “Milhoes de pessoas... sonhos... Explosoes...",
						390, 400, 500, true);
	}

	@Override
	public void show() {
		WorldSettings.toggleVirtualScreen(false);
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	private float red = 1;
	private int distance = 2000;
	private float time = 0;
	private float FINISH_TIME = 7;
	
	/** updates Screen logic */
	@Override
	public void act(float delta) {
		
		textMan.update(delta);
		
		if (time > FINISH_TIME) {
			textMan.newText("Caracteristicas do remetente: Metodo de criptografia semelhante ao da extinta organizacao terrorista Tyrannos - fabricante clandestino de armamento nuclear pesado e responsavel pelo terrivel marco da explosao da  A.N.T.A. (Aereal Non-Tripulated Armageddon) em 1965",
					390, 450, 500, true);
			
			time = 0;
		}
		
		time += delta;
		
		if (time > FINISH_TIME || (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) && !transition)
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
				illumination.setColor(Color.RED);
				distance-=20;
				
				if (distance <= 0) {
						WorldSettings.setWorldSize(100, WorldSettings.heightFix(100));
						WorldSettings.toggleVirtualScreen(false);
						WorldSettings.setCameraPosition(50, WorldSettings.heightFix(50));
						try {
							ScreenCreator.switchAndGo("SnakeScreen", "TiledMap", "maps/level1.tmx");
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}
		}
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

