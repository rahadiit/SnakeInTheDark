package snake.interfacesAndAbstract;

import snake.levelSettings.WorldSettings;
import snake.levelSettings.WorldStage;
import com.badlogic.gdx.scenes.scene2d.Group;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings && --------- (modifiable according to need)
 */


public abstract class GameWorld extends Group /* Group makes it connected to MapEntities */ {
	
	public GameWorld () {
		this.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
	}
	
	@Override
	public WorldStage getStage() {
		return (WorldStage) super.getStage();
	}
	
	public abstract void dispose();
}
