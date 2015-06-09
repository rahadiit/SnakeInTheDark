package snake.visuals.enhanced;

import com.badlogic.gdx.scenes.scene2d.Actor;
import snake.engine.models.GameWorld;
import snake.map.MapEntity;

/**                              Developed By:
 *                               NoDarkGlasses
 *
 * <br />
 * Entity that belongs to a VisualGameWorld
 *
 * @author Mr.Strings
 */
public abstract class LightMapEntity extends MapEntity implements ILightMapEntity {

	public LightMapEntity(GameWorld world) {
		super(world);
	}
	
	
	public LightMapEntity() {}

	@Override
	public void createLights() {
		for (Actor child : getChildren())
			if (child instanceof ILightMapEntity)
			    ((ILightMapEntity) child).createLights();
	}
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}

}
