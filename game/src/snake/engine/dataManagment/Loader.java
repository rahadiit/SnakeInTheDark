package snake.engine.dataManagment;

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
		getManager().load(filename, type);
	}
	
	public static <T> T get(String filename) {
		return getManager().get(filename);
	}
	
	public static boolean isLoaded (String filename) {
		return getManager().isLoaded(filename);
	}
	
	public static void finishLoadingAsset(String filename) {
		getManager().finishLoadingAsset(filename);
	}
	
	public static void update() {
		getManager().update();
	}
	
	public static void unload(String filename) {
		getManager().unload(filename);
	}
}
