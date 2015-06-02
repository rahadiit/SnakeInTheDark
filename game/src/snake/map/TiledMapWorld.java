package snake.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import snake.engine.creators.WorldSettings;
import snake.visuals.enhanced.VisualGameWorld;

public class TiledMapWorld extends VisualGameWorld {

    private Map currentMap;
    private MapManager manager;
    private TiledMapRenderer renderer;

    public TiledMapWorld(String mapName) {
        manager = new MapManager();
        setMap(manager.loadMap(mapName));
    }

    public void setMap(TiledMap map) {
        currentMap = map;
        renderer = new OrthogonalTiledMapRenderer(map, 1 / 32f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        renderer.setView((OrthographicCamera) getStage().getCamera());
        renderer.render();
    }

    @Override
    public void show() {
        WorldSettings.setAmbientColor(Color.WHITE);
        OrthographicCamera camera = (OrthographicCamera) getStage().getCamera();
        float wFactor = 8f / camera.viewportWidth;
        float hFactor = 8f / camera.viewportHeight;
        float factor = Math.max(wFactor, hFactor);
        camera.setToOrtho(false, 8, 8);
        camera.position.set(4f, 4f, 0);
        camera.zoom = factor;
        camera.update();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void createLights() {
    }
}
