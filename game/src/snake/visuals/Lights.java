package snake.visuals;

import box2dLight.RayHandler;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Controls application Light system.  </br>
 * @author Mr.Strings
 */

public class Lights {
	static float CONVERT2PHYSICS = 1;
	private static World physicsWorld;
	private static RayHandler handler;
	public static boolean isActive = true;
	
	
	
	
	/** Creates Box2d physics world for a illumination system
	 * 
	 * @param ratio - ratio between Box2dMeters and application measures 
	 * @return World created
	 */
	public static World	createWorld(float ratio) {
		
		physicsWorld = new World(new Vector2(0,0), true);
		CONVERT2PHYSICS = ratio;
		return physicsWorld;
	}
	
	
	public static RayHandler createRayHandler (World world) {
		handler = new RayHandler(world);
		return handler;
	}
	
	public static void setWorld(World world) {
		if (world == null) {
			physicsWorld = world;
		}
	}
	
	public static void setRayhandler (RayHandler rayHandler) {
		handler = rayHandler;
	}
	
	public static void setConversionRatio(float ratio) {
		CONVERT2PHYSICS = ratio;
	}
	
	public static RayHandler getRayhandler () {
		return handler;
	}
	
	public static World getWorld() {
		return physicsWorld;
	}

}
