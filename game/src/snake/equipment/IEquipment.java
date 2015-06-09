package snake.equipment;

import com.badlogic.gdx.graphics.g2d.Batch;

import snake.map.IMapAccess;
import snake.visuals.enhanced.ILightMapEntity;

public interface IEquipment extends ILightMapEntity
{
	void activateOnMap(IMapAccess map);
	String getDescription();
	String getName();
	void draw(Batch batch, float parentAlpha);
	void setOnMap(boolean onMap);
}
