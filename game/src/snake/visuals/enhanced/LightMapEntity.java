package snake.visuals.enhanced;

import com.badlogic.gdx.scenes.scene2d.Actor;
import snake.engine.models.GameWorld;
import snake.map.MapEntity;

/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Entity that belongs to a VisualGameWorld </br>             
 * 
 * @author Mr.Strings
 * 
 */

public abstract class LightMapEntity extends MapEntity{

	public LightMapEntity(GameWorld world) {
		super(world);
	}
	
	
	public LightMapEntity() {}
	
	public abstract boolean hasLights();
	
	public void createLights() {
		for (Actor x : this.getChildren()) {
			try {
				LightMapEntity ent = (LightMapEntity) x;
				ent.createLights();
			} catch (ClassCastException e){}
		}
	}

	public void disposeLights() {
		for (Actor x : this.getChildren()) {
			try {
				LightMapEntity ent = (LightMapEntity) x;
				ent.disposeLights();
			} catch (ClassCastException e){}
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
		disposeLights();
	}
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}

}
