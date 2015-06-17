package snake.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapRenderer;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.player.Player;
import snake.visuals.enhanced.ILightMapEntity;
import snake.visuals.enhanced.LightMapEntity;
import snake.visuals.enhanced.VisualGameWorld;

public class TiledMapWorld extends VisualGameWorld {

    private MapManager manager;
    private MapRenderer renderer;
    
    private Music song1, song2;
    private String song2Name = "music/nine-lies-the-heart-ed-4.wav", song1Name = "music/yewbic__ambience02.wav";
    
    private boolean playing = true;
    

    public TiledMapWorld(String mapName) {
        manager = new MapManager();

        Player player = Player.getInstance(this);
        player.attach(manager);
        manager.loadMap(mapName);
        renderer = manager.createRenderer();

        manager.addEntityDirect(player);
        manager.moveToSpawnPoint(player);

        Loader.load(song1Name, Music.class);
        Loader.finishLoadingAsset(song1Name);
        song1 = Loader.get(song1Name);


        Loader.load(song2Name, Music.class);
        Loader.finishLoadingAsset(song2Name);
        song2 = Loader.get(song2Name);
    }

    public IMapAccess getMapAccess() {
        return manager;
    }

    @Override
    public void act(float delta) {
    	if (playing) {
        	manager.tickEntities(delta);
    	}
    	
    	if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
    		playing = !playing;
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
        WorldSettings.setAmbientColor(Color.WHITE);

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
        
        song2.play();
        song2.setLooping(true);
    }

    @Override
    public void hide() {
    	this.song2.stop();
    	this.song1.stop();
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
        manager.createLights();
    }
}
