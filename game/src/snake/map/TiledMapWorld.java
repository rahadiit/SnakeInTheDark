package snake.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

        Input input = Gdx.input;

        //Camera Movement
        if (input.isKeyPressed(Input.Keys.LEFT))
            getStage().getCameraMan().moveCamera(-20f * delta, 0);

        if (input.isKeyPressed(Input.Keys.RIGHT))
            getStage().getCameraMan().moveCamera(20f * delta, 0);

        if (input.isKeyPressed(Input.Keys.DOWN))
            getStage().getCameraMan().moveCamera( 0, -20f * delta);

        if (input.isKeyPressed(Input.Keys.UP))
            getStage().getCameraMan().moveCamera(0, 20f * delta);

        //Camera Zoom
        if (input.isKeyPressed(Input.Keys.O))
            getStage().getCameraMan().zoomCamera(-.5f * delta);

        if (input.isKeyPressed(Input.Keys.P))
            getStage().getCameraMan().zoomCamera(.5f * delta);


        //Virtual Camera Movement
        if (input.isKeyPressed(Input.Keys.L))
            getStage().getCameraMan().moveVCamera(.01f, 0);

        if (input.isKeyPressed(Input.Keys.J))
            getStage().getCameraMan().moveVCamera(-.01f, 0);

        if (input.isKeyPressed(Input.Keys.I))
            getStage().getCameraMan().moveVCamera(0, .01f);

        if (input.isKeyPressed(Input.Keys.K))
            getStage().getCameraMan().moveVCamera(0, -.01f);

        //Virtual Camera Zoom
        if (input.isKeyPressed(Input.Keys.U))
            getStage().getCameraMan().zoomVCamera(.01f);

        if (input.isKeyPressed(Input.Keys.Y))
            getStage().getCameraMan().zoomVCamera(-.01f);
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
    }

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}

    @Override
    public void createLights() {}
}
