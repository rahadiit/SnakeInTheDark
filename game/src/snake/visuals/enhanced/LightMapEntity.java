package snake.visuals.enhanced;

import com.badlogic.gdx.scenes.scene2d.Group;
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
	
	public LightMapEntity(Group group) {
		super(group);
	}
	
	public LightMapEntity() {}
	
	public abstract boolean hasLights();
	
	public abstract void createLights();

	public abstract void disposeLights();
	
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}

}
