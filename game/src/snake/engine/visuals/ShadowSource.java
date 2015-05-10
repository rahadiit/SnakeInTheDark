package snake.engine.visuals;

import com.badlogic.gdx.physics.box2d.Body;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @author Mr.Strings
 */


public class ShadowSource {
	Body body;

	ShadowSource() {}
	
	void createBody (Body body) {
		this.body = body;
	}
	
	
	public void moveBody (int x, int y) {
		moveBody(x, y, 0);
	}
	
	public void moveBody (int x, int y, int angle) {
		body.setTransform(x * Lights.CONVERT2PHYSICS, y* Lights.CONVERT2PHYSICS, angle);
	}
	
	
	
	public Body getBody () {
		return body;
	}
	
	
	public void destroyShadow() {
		Lights.getWorld().destroyBody(body);
	}
}
