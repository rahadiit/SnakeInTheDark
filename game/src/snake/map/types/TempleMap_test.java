package snake.map.types;

import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.map.sets.Box_Test;
import snake.player.Magician_Test;
import snake.visuals.enhanced.LightMapEntity;
import snake.visuals.enhanced.VisualGameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * Map for testing purposes only.
 * @author Mr.Strings
 */

public class TempleMap_test extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Sprite temple;
	private Magician_Test magician; //Da pra colocar uma array com todas as entities? 
	private Box_Test box; // Provavelmente sim.
	
	public TempleMap_test (String LevelData/* Add other parameters of choice*/) {
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		Texture texture = new Texture(Gdx.files.internal("pixelArtTemple.png")); 
		temple = new Sprite(texture);
		temple.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		magician = new Magician_Test(this);
		box = new Box_Test(this);
	}
	
	
	public void show () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		

		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			String[] param = {"SnakeScreen", "ForestMap", "Some random Data"};
			try {
				ScreenCreator.addAndGo(param);
			}  catch (Exception e) {
				System.out.println ("Could not switch Screens");
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
			try {
				ScreenCreator.backToPrevious();
			} catch (Exception e) {
				String[] param = {"SnakeLevel", "MainMenu", "LevelDataID"};
				try {
					ScreenCreator.switchAndGo(param);
				} catch (Exception excp) {
					System.out.println("Couldn't switch screens.");
				}
			}
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			WorldSettings.setAmbientColor(new Color (.1f, .1f, .3f, 1f));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			WorldSettings.setAmbientColor(Color.WHITE);
		}
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		temple.draw(batch);
		super.draw(batch, parentAlpha);
	}

	public void createLights() {
		for (Actor x : this.getChildren()) {
			LightMapEntity ent = (LightMapEntity) x;
			ent.createLights();
		}
	}
	
	@Override
	public void dispose() {
		temple.getTexture().dispose();
		
		box.disposeLights();
		magician.disposeLights();
	}

}
