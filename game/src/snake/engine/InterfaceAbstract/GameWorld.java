package snake.engine.InterfaceAbstract;

import snake.engine.creators.WorldSettings;
import snake.engine.creators.WorldStage;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * Module: Mr.Strings && --------- (modifiable according to need)
 */


public abstract class GameWorld extends Group /* Group makes it connected to MapEntities */ {
	
	public GameWorld () {
		this.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
	}
	
	@Override
	public Stage getStage() {
		if (super.getStage() instanceof WorldStage)
			return (WorldStage) super.getStage();
		else
			throw new UnsupportedOperationException("MapEntity has to be in a WorldStage.");
	}
	
	public abstract void dispose();
}
