package snake.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapRenderer;
import snake.drone.Drone;
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
        
        IMapEntity player = Player.getInstance(this);
        manager.addEntity(player);
        manager.moveToSpawnPoint(player);
        
        IMapEntity drone = new Drone(this, 2, 2, "baixo");
        manager.addEntity(drone);
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
        WorldSettings.setAmbientColor(new Color(1f, 1f, 1f, 1f)); ///TODO: fix ambient light


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
        manager.disposeEntities();
    }

    @Override
    public void createLights() {
        for (IMapEntity entity : manager.getEntities())
            if (entity instanceof ILightMapEntity)
                ((LightMapEntity) entity).createLights();
    }
}
