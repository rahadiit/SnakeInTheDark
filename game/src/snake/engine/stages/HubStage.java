package snake.engine.stages;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.engine.MainMenu;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 *  <br> Extension of stage in HUB -- gives easy access to menu and, consequently, elements in it </br>
 *  <br> Note: Not used yet
 *  @author Mr.Strings
 */


public class HubStage extends Stage{
	MainMenu menu;
	
	public HubStage(MainMenu menu) {
		super();
		this.menu = menu;
	}
	
	public HubStage(MainMenu menu, Viewport viewport) {
		super(viewport);
		this.menu =menu;
	}
	
	public HubStage(MainMenu menu, Viewport viewport, Batch batch) {
		super(viewport, batch);
		this.menu = menu;
	}
	
	public MainMenu getMenu() {
		return menu;
	}
}
