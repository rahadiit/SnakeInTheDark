package snake.engine.dataManagment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * Module: ------
 */

public class Loader {
	private static AssetManager assetMan = null;
	
	private Loader() {};
	
	public static AssetManager getManager () {
		if (assetMan == null)
			assetMan = new AssetManager ();
		return assetMan;
	}
	
	public static <T> void load (String filename, Class<T> type) {
		getManager().load(Gdx.files.internal(filename).name(), type);
	}
	
	public static <T> T get(String filename) {
		return getManager().get(Gdx.files.internal(filename).name());
	}
	
	public static boolean isLoaded (String filename) {
		return getManager().isLoaded(Gdx.files.internal(filename).name());
	}
	
	public static void update() {
		getManager().update();
	}
	
	public static void unload(String filename) {
		getManager().unload(Gdx.files.internal(filename).name());
	}
}
