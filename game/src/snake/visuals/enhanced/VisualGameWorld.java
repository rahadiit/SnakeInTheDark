package snake.visuals.enhanced;

import com.badlogic.gdx.scenes.scene2d.Actor;
import snake.engine.models.GameWorld;
import snake.map.IMapEntity;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Extension of game world that supports lights </br>
 * Module: Mr.Strings
 */


public abstract class VisualGameWorld extends GameWorld {
	
	@Override
	public String getPreferredStage() {
		return "Visual World Stage";
	}
	
	public void createLights() {
		for (Actor a: this.getChildren()) {
			if (a instanceof LightMapEntity) {
				ILightMapEntity e = (LightMapEntity) a;
				e.createLights();
			}
		}
	}
	
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}
}
