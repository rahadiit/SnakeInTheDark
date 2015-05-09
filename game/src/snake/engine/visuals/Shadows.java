package snake.engine.visuals;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;



/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @author Mr.Strings
 */


public abstract class Shadows {
	

	public static ShadowSource createCircleShadowSource(float radius, float posx, float posy) {
		

		BodyDef bodyDef = new BodyDef();
		
		bodyDef.type = BodyType.KinematicBody;
		
		bodyDef.position.set(posx, posy);
	
		ShadowSource body = (ShadowSource) Lights.getWorld().createBody(bodyDef);

		CircleShape circle = new CircleShape();
		circle.setRadius(radius);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;

		body.createFixture(fixtureDef);

		circle.dispose();
		
		return body;
	}
	
	public static ShadowSource createRectShadowSource (int width, int height, int posx, int posy) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		
		bodyDef.position.set(posx, posy);
		
		ShadowSource body = (ShadowSource) Lights.getWorld().createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
      
        shape.setAsBox(width/2, height/2);
        
        body.createFixture(shape, 0);
		
		return body;
	}
	
	
	public static ShadowSource createShadowSource (BodyDef bodyDef) {
		return (ShadowSource) Lights.getWorld().createBody(bodyDef);
	}
	
	
	public static void removeShadowSource (Body shadow) {
		Lights.getWorld().destroyBody(shadow);
	}
}
