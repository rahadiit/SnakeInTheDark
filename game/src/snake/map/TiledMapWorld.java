package snake.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapRenderer;
import snake.engine.creators.WorldSettings;
import snake.player.Player;
import snake.visuals.enhanced.ILightMapEntity;
import snake.visuals.enhanced.LightMapEntity;
import snake.visuals.enhanced.VisualGameWorld;

public class TiledMapWorld extends VisualGameWorld {

    private MapManager manager;
    private MapRenderer renderer;

    public TiledMapWorld(String mapName) {
        manager = new MapManager();
        manager.loadMap(mapName);
        renderer = manager.createRenderer();
        
        IMapEntity player = Player.getinstance(this);
        manager.addEntity(player);
    }

    public IMapAccess getMapAccess() {
        return manager;
    }

    @Override
    public void act(float delta) {
        manager.tickEntities(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        OrthographicCamera camera = (OrthographicCamera) getStage().getCamera();
        renderer.setView(camera);
        renderer.render();
        batch.begin();

        manager.drawEntities(batch, parentAlpha);
    }

    @Override
    public void show() {
        WorldSettings.setAmbientColor(new Color(.05f, .05f, .05f, 1f));

        OrthographicCamera camera = (OrthographicCamera) getStage().getCamera();
        int width = manager.getMapWidth();
        int height = manager.getMapHeight();
        float wFactor = width / camera.viewportWidth;
        float hFactor = height / camera.viewportHeight;
        float factor = Math.max(wFactor, hFactor);
        camera.setToOrtho(false, width, height);
        camera.position.set(width * .5f, height * .5f, 0);
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
        for (IMapEntity entity : manager.getEntities()) {
            entity.dispose();
            if (entity instanceof ILightMapEntity)
                ((LightMapEntity) entity).disposeLights();
        }
    }

    @Override
    public void createLights() {
        for (IMapEntity entity : manager.getEntities())
            if (entity instanceof ILightMapEntity)
                ((LightMapEntity) entity).createLights();
    }
}
