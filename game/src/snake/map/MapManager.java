package snake.map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import snake.engine.dataManagment.Loader;
import snake.equipment.EquipmentCreator;
import snake.equipment.IEquipment;

import java.util.*;

public class MapManager implements IMapAccess {

    private static final AssetManager assetManager;

    static {
        assetManager = Loader.getManager();
        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
    }

    private TiledMap map;

    private final List<IMapEntity> entities = new LinkedList<>();
    private final List<IMapEntity> entitiesWrapper = Collections.unmodifiableList(entities);

    private final List<String> availableEquipments = new ArrayList<>();

    private int mapWidth;
    private int mapHeight;
    private int tileWidth;
    private int tileHeight;

    private Random random = new Random();

    @Override
    public List<IMapEntity> getEntities() {
        return entitiesWrapper;
    }

    @Override
    public boolean addEntity(IMapEntity entity) {
        return entities.add(entity);
    }

    @Override
    public boolean removeEntity(IMapEntity entity) {
        return entities.remove(entity);
    }

    public void clearEntities() {
        entities.clear();
    }

    public void tickEntities(float delta) {
        for (IMapEntity entity : entities)
            entity.act(delta);
    }

    public void drawEntities(Batch batch, float parentAlpha) {
        for (IMapEntity entity : entities)
            entity.draw(batch, parentAlpha);
    }

    public void preloadMap(String name) {
        assetManager.load(name, TiledMap.class);
    }

    public void loadMap(String name) {
        preloadMap(name);
        assetManager.finishLoadingAsset(name);
        map = assetManager.get(name);

        entities.clear();
        availableEquipments.clear();

        MapProperties properties = map.getProperties();
        mapWidth = properties.get("width", Integer.class);
        mapHeight = properties.get("height", Integer.class);
        tileWidth = properties.get("tilewidth", Integer.class);
        tileHeight = properties.get("tileheight", Integer.class);

        String equips = properties.get("equipList", "", String.class);
        Collections.addAll(availableEquipments, equips.split(","));
        int equipQuantity = Integer.parseInt(properties.get("equipQuantity", "0", String.class));
        spawnEquipments(equipQuantity);
    }

    public MapRenderer createRenderer() {
        int tileSize = Math.min(tileWidth, tileHeight);
        return new OrthogonalTiledMapRenderer(map, 1f / tileSize);
    }

    private void spawnEquipments(int equipQuantity) {
        TiledMapTileLayer baseLayer = (TiledMapTileLayer) map.getLayers().get("base");

        for (int i = 0; i < equipQuantity; i++) {
            String cellType;
            Cell cell;
            int x, y;
            boolean alreadySpawned;

            do {
                x = random.nextInt(mapWidth);
                y = random.nextInt(mapHeight);

                cell = baseLayer.getCell(x, y);
                MapProperties properties = cell.getTile().getProperties();

                cellType = properties.get("type", "", String.class);
                alreadySpawned = properties.get("spawned", false, Boolean.class);
            } while (!cellType.equals("floor") && !alreadySpawned);

            cell.getTile().getProperties().put("spawned", true);

            int index = random.nextInt(availableEquipments.size());
            IEquipment equipment = EquipmentCreator.createFactory(availableEquipments.get(index)).create(x, y, true);

            addEntity(equipment);
        }
    }

    @Override
    public CellType getCellType(int x, int y) {
        TiledMapTileLayer baseLayer = (TiledMapTileLayer) map.getLayers().get("base");
        Cell cell = baseLayer.getCell(x, y);
        MapProperties properties = cell.getTile().getProperties();

        String cellType = properties.get("type", "", String.class);

        try {
            return CellType.valueOf(cellType.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public void setCellType(int x, int y, CellType type) {
        TiledMapTileLayer baseLayer = (TiledMapTileLayer) map.getLayers().get("base");
        Cell cell = baseLayer.getCell(x, y);
        MapProperties properties = cell.getTile().getProperties();

        properties.put("type", type.toString().toLowerCase(Locale.ENGLISH));
        // TODO: mudar tile quando alterar o tipo
    }

    @Override
    public int getMapWidth() {
        return mapWidth;
    }

    @Override
    public int getMapHeight() {
        return mapHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }
}
