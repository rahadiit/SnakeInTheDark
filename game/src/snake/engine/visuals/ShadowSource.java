package snake.engine.visuals;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @author Mr.Strings
 */


public class ShadowSource extends Body {

	protected ShadowSource(World world, long addr) {
		super(world, addr);
		// TODO Auto-generated constructor stub
	}
	
	
	public void moveBody (int x, int y, int angle) {
		this.setTransform(x * Lights.CONVERT2PHYSICS, y* Lights.CONVERT2PHYSICS, angle);
	}
	
	public void moveBody (int x, int y) {
		moveBody(x, y, 0);
	}
	
	

}
