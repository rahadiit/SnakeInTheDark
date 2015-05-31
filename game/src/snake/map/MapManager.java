package snake.map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import snake.engine.dataManagment.Loader;

public class MapManager {

    private static final AssetManager assetManager;

    static {
        assetManager = Loader.getManager();
        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
    }

    public void preloadMap(String name) {
        assetManager.load(name, TiledMap.class);
    }

    public TiledMap loadMap(String name) {
        if (!assetManager.isLoaded(name)) {
            assetManager.load(name, TiledMap.class);
            assetManager.finishLoadingAsset(name);
        }

        return assetManager.get(name);
    }
}
