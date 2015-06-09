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


public abstract class VisualGameWorld extends GameWorld{
	
	@Override
	public String getPrefferedStage() {
		return new String ("Visual World Stage");
	}
	
	public void createLights() {
		for (Actor a: this.getChildren()) {
			if (a instanceof ILightMapEntity) {
				ILightMapEntity e = (ILightMapEntity) a;
				e.createLights();
			}
		}
	}
	
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		for (Actor a: this.getChildren()) {
			if (a instanceof ILightMapEntity) {
				ILightMapEntity e = (ILightMapEntity) a;
				e.disposeLights();
				e.dispose();
			}
			else if (a instanceof IMapEntity) {
				IMapEntity e = (IMapEntity) a;
				e.dispose();
			}
		}
	}
}
