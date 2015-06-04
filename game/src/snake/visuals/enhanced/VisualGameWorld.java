package snake.visuals.enhanced;

import com.badlogic.gdx.scenes.scene2d.Actor;
import snake.engine.models.GameWorld;


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
	
	public abstract void createLights();
	
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		for (Actor a: this.getChildren()) {
			try {
				LightMapEntity e = (LightMapEntity) a;
				e.disposeLights();
			} catch (ClassCastException e){}
		}
	}
}
