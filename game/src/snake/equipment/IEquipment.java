package snake.equipment;

import com.badlogic.gdx.graphics.g2d.Batch;

import snake.map.IMapAccess;

public interface IEquipment 
{
	public void activate(IMapAccess map);
	public String getDescription();
	public String getName();
	void draw(Batch batch, float parentAlpha);
}
