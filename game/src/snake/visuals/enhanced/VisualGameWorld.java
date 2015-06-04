package snake.visuals.enhanced;

import com.badlogic.gdx.scenes.scene2d.Actor;
import snake.engine.models.GameWorld;
import snake.map.MapEntity;


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
			try {
				LightMapEntity e = (LightMapEntity) a;
				e.createLights();
			} catch (ClassCastException e){}
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
			try {
				LightMapEntity e = (LightMapEntity) a;
				e.disposeLights();
			} catch (ClassCastException e){}
			try {
				MapEntity e = (MapEntity) a;
				e.dispose();
			} catch (ClassCastException e){}
		}
	}
}
