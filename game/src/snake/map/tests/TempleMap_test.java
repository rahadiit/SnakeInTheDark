package snake.map.tests;

import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.equipment.EquipmentCreator;
import snake.equipment.IEquipment;
import snake.tests.Magician_Test;
import snake.tests.Box_Test;
import snake.tests.Player;
import snake.visuals.enhanced.LightMapEntity;
import snake.visuals.enhanced.VisualGameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Map for testing purposes only. (BETTER DESIGN) </br>
 * @author Mr.Strings
 */

public class TempleMap_test extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Sprite temple;
	//private Magician_Test magician; //Da pra colocar uma array com todas as entities? 
	private Magician_Test magician;
	private Box_Test box; // Provavelmente sim.
	private String texName = "demos/pixelArtTemple.png";
	
	public TempleMap_test (String LevelData/* Add other parameters of choice*/) {
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(texName, Texture.class);
		Loader.finishLoadingAsset(texName);
		
		//Cria a imagem
		Texture texture = Loader.get(texName);
		temple = new Sprite(texture);
		temple.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		
		//Cria o Player
		magician = new Magician_Test(this);
		//magician = new Player(this); //Player
		magician.setPosition(0, WorldSettings.heightFix(0)); // Perceba o heightFix -- otimo para trabalhar com porcentagem em relacao ao mundo
		//... Com o heightFix, o topo fica 100, o chao fica 0 (Highly recommended)
	
		//Cria uma caixa
		box = new Box_Test(this); //Simple box with shadow
		box.setPosition(38, WorldSettings.heightFix(53));
				
		// VC PASSA A POSI??????O INICIAL DO EQUIPAMENTO, TEM A VERS???O DO CONSTRUTOR SEM ISSO TBM!
		IEquipment flashlight = EquipmentCreator.createFactory("flashlight").create(20, 20, true); //Equipment
		this.addActor((Group)flashlight); //Added to group // added to this map
		
		createLights();
	}
	
	
	public void show () {
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		

		//Adds new screen on top of this one
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			String[] param = {"SnakeScreen", "tiledmap", "maps/testmap.tmx"};
			try {
				ScreenCreator.addAndGo(param);
			}  catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
		
		//Back to previous screen
		if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
			try {
				ScreenCreator.backToPrevious();
			} catch (Exception e) { //OR... Create a menu to go back
				String[] param = {"SnakeLevel", "MainMenu", "LevelDataID"};
				try {
					ScreenCreator.switchAndGo(param); 
				} catch (Exception excp) {
					e.printStackTrace(System.out);
				}
			}
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			WorldSettings.setAmbientColor(new Color (.1f, .1f, .3f, 1f));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			WorldSettings.setAmbientColor(Color.WHITE);
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
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		temple.draw(batch);
		super.drawChildren(batch, parentAlpha);
	}

	public void createLights() {
		for (Actor x : this.getChildren()) {
			try {
				LightMapEntity ent = (LightMapEntity) x;
				ent.createLights();
			} catch (ClassCastException e){}
		}
	}
	
	@Override
	public void dispose() {
		Loader.unload(texName);
		super.dispose();
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
